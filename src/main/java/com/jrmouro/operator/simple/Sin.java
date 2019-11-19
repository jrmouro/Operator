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
public class Sin extends SimpleFunctionOperator{

    public Sin() {
        super("sin");
    }
    
    public Sin(Operator child) {
        super("sin", child);
    }

    @Override
    public double operate(double value) {
        return Math.sin(value);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new Sin(this.child.getCopy());
        return new Sin();
    }
    
}
