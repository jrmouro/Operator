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
public class Sum extends SimpleOperator{

    public Sum() {
        super("+");
    }
    
    public Sum(Operator... child) {
        super("+", child);
    }
    
    public Sum(int limit) {
        super(limit, "+", new ConstOp(1.0));
    }    
    
    public Sum(int limit, Operator... child) {
        super(limit, "+", child);
    }
    
    @Override
    public double operate(double value1, double value2) {
        return value1 + value2;
    }

    @Override
    public Operator getCopy() {
        return new Sum();
    }
    
}
