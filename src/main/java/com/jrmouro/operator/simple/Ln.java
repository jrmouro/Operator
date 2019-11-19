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
public class Ln extends SimpleFunctionOperator{

    public Ln() {
        super("log");
    }
    
    public Ln(Operator child) {
        super("log", child);
    }

    @Override
    public boolean validValue(double value) {
        return value > 0.0;
    }
    
    @Override
    public double operate(double value) {
        return Math.log(value);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new Ln(this.child.getCopy());
        return new Ln();
    }
    
}