/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.simple;

import com.jrmouro.operator.simple.SimpleFunctionOperator;

/**
 *
 * @author ronaldo
 */
public class Log  extends SimpleFunctionOperator{

    public Log() {
        super("log10");
    }
    
    public Log(Operator child) {
        super("log10", child);
    }
    
    @Override
    public boolean validValue(double value) {
        return value > 0.0;
    }

    @Override
    public double operate(double value) {
        return Math.log(value) / Math.log(10.0);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new Log(this.child.getCopy());
        return new Log();
    }
    
}
