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
    
    final int limit;
    
    public Exp(int limit){
        super("**", new ConstOp(1.0));
        this.limit = limit;
    }

    public Exp(){
        super("**", new ConstOp(1.0));
        this.limit = 2;
    }
    
    public Exp(Operator... child) {
        super("**", child);
        this.limit = 2;
    }
    
    @Override
    public double operate(double value1, double value2) {
        return Math.pow(value1, value2);
    }

    @Override
    public Operator getCopy() {
        return new Exp(this.limit);
    }
    
    @Override
    final public boolean term() {
        return this.children.size() > this.limit;
    }
    
    
}