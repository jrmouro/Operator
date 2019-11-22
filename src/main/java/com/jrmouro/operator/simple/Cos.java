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
public class Cos  extends SimpleFunctionOperator{

    public Cos() {
        super("cos");
    }
    
    public Cos(Operator child) {
        super("cos", child);
    }

    @Override
    public double operate(double value) {
        return Math.cos(value);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new Cos(this.child.getCopy());
        return new Cos();
    }
       
}