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
public class Mul extends SimpleOperator{

    public Mul() {
        super("*", new ConstOp(1.0));
    }
    
    @Override
    public double operate(double value1, double value2) {
        return value1 * value2;
    }

    @Override
    public Operator getCopy() {
        return new Mul();
    }
    
}