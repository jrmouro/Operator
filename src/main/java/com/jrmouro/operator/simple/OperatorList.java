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

        int i = 0;
        
        for (; i < this.children.size(); i++) {

            ret = this.children.get(i).aval();

            if (Double.isFinite(ret)){
                i++;
                break;
            }
            
        }

        
        for (; i < this.children.size(); i++) {

            double aux = this.children.get(i).aval();

            if (Double.isFinite(aux)){
                
                if(this.validValues(ret, aux))
                    ret = this.operate(ret, aux);
                else
                    ret = aux;
                
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
        if (!this.term()) {
            this.children.add(0, child);
        }
    }

    @Override
    final public Iterator<Operator> iterator() {
        return this.children.iterator();
    }

    @Override
    final public String toString() {

        List<Operator> list = getValidList();
        
        if (list.isEmpty()) {
            return "0.0";
        }

        String ret = "(";

        int i = 0;

        for (; i < list.size() - 1; i++) {
            ret += list.get(i).toString() + this.opStr;
        }

        ret += list.get(i).toString() + ")";

        return ret;

    }
    
    private List<Operator> getValidList(){
        
        List<Operator> retList = new ArrayList();
        
        int i = 0;
        
        double ret = 0.0;
        
        for (; i < this.children.size(); i++) {

            ret = this.children.get(i).aval();

            if (Double.isFinite(ret)){
                retList.add(this.children.get(i));
                i++;
                break;
            }
            
        }

        
        for (; i < this.children.size(); i++) {

            double aux = this.children.get(i).aval();

            if (Double.isFinite(aux)){
                
                if(this.validValues(ret, aux)){
                    ret = this.operate(ret, aux);
                }else{
                    ret = aux;
                    retList.clear();
                }
                
                retList.add(this.children.get(i));
                
            }

        }
        
        
        return retList;
    }

    public abstract boolean validValues(double value1, double value2);

    public abstract double operate(double value1, double value2);

}
