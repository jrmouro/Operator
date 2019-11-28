/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.simple;

/**
 *
 * @author ronaldo
 */
public abstract class SimpleFunctionOperator implements Operator {

    final String op;
    Operator child = null;

    public SimpleFunctionOperator(String op, Operator child) {
        this.op = op;
        this.child = child;
    }

    public SimpleFunctionOperator(String op) {
        this.op = op;
    }

    public abstract double operate(double value);

    @Override
    public double aval() {

        double ret = 0.0;

        if (this.child != null)
            ret = this.operate(this.child.aval());
        

        return ret;
    }

    @Override
    public String toString() {

        String ret = "0.0";

        if (this.child != null)
            ret = op + "(" + this.child.toString() + ")";
            
        return ret;

    }

    @Override
    public boolean term() {
        return (this.child != null);
    }

    @Override
    public void add(Operator child) {
        if(!this.term())
            this.child = child;
    }

}
