/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public abstract class OperatorList implements Operator, Iterable<Operator> {

    final protected List<Operator> children = new ArrayList();
    final String opStr;

    public OperatorList(String opStr, Operator... child) {

        this.opStr = opStr;

        this.children.addAll(Arrays.asList(child));

    }

    public OperatorList(String opStr) {

        this.opStr = opStr;

    }

    @Override
    final public double aval() {

        double ret = 0.0;

        if (this.children.size() > 0) {

            ret = this.children.get(0).aval();

            for (int i = 1; i < this.children.size(); i++) {
                ret = this.operate(ret, this.children.get(i).aval());
            }

        }

        return ret;

    }

    @Override
    public boolean term() {
        return false;
    }

    @Override
    public void add(Operator child) {
        if (!this.term())
            this.children.add(0, child);
    }

    @Override
    final public Iterator<Operator> iterator() {
        return this.children.iterator();
    }

    @Override
    final public String toString() {
        
        String ret = "0.0";

        if (!this.children.isEmpty()) {            
            
            ret = "(";
            
            int i = 0;

            for (; i < this.children.size() - 1; i++) 
                ret += this.children.get(i).toString() + this.opStr;
            

            ret += this.children.get(i).toString() + ")";
            
        }

        
        return ret;

    }

    public abstract double operate(double value1, double value2);

}
