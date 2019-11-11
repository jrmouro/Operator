/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public abstract class OperatorList implements Operator, Iterable<Operator> {

    final List<Operator> children = new ArrayList();   

    public OperatorList(Operator child) {
        this.children.add(child);
    }
    
    

    @Override
    final public double aval() {

        double ret = 0.0;

        if (this.children.size() > 0) {

            ret = this.children.get(0).aval();
            
            for (int i = 1; i < this.children.size(); i++) {
                
                double aux = this.children.get(i).aval();

                if (Double.isFinite(aux)&& this.validValues(ret, aux)) {
                    ret = this.operate(ret, aux);
                }
                
            }           

        }

        return ret;

    }

    @Override
    final public boolean term() {
        return false;
    }

    @Override
    final public void add(Operator child) {
        if(!this.term())
            this.children.add(0, child);
    }

    @Override
    final public Iterator<Operator> iterator() {
        return this.children.iterator();
    }

    @Override
    final public String toString() {

        List<Operator> aux = new ArrayList();

        for (Operator child : this) {

            if (Double.isFinite(child.aval())) {
                aux.add(child);
            }

        }
        
        Operator[] array = new Operator[aux.size()];
        aux.toArray(array); 
        
        return this.stringOperate(array);
        
    }
    
    public abstract String stringOperate(Operator... ops);
    public abstract boolean validValues(double value1, double value2);
    public abstract double operate(double value1, double value2);

}
