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
public class Exp extends SimpleOperator{
    
    public Exp(){
        super("**");
    }
    
    public Exp(Operator... child) {
        super("**", child);
    }
    
    public Exp(int limit) {
        super(limit, "**", new ConstOp(1.0));
    }    
    
    public Exp(int limit, Operator... child) {
        super(limit, "**", child);
    }
            
    @Override
    public double operate(double value1, double value2) {
        return Math.pow(value1, value2);
    }

    @Override
    public Operator getCopy() {
        return new Exp();
    }   
    
}