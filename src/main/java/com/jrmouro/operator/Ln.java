/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

/**
 *
 * @author ronaldo
 */
public class Ln extends SimpleFunctionOperator{

    public Ln() {
        super("log", new ConstOp(1.0));
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
        return new Ln();
    }
    
}