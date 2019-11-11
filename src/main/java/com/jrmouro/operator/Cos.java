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
public class Cos  extends SimpleFunctionOperator{

    public Cos() {
        super("cos", new ConstOp(0.0));
    }

    @Override
    public double operate(double value) {
        return Math.cos(value);
    }

    @Override
    public Operator getCopy() {
        return new Cos();
    }
       
}