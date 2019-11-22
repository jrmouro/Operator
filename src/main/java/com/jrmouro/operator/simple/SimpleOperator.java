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
public abstract class SimpleOperator extends OperatorList{
    
    int limit = Integer.MAX_VALUE - 1;
    
    public SimpleOperator(int limit, String op) {
        super(op);
        this.limit = limit;
    }    

    public SimpleOperator(int limit, String op, Operator... child) {
        super(op, child);
        this.limit = limit;
    }
    
    public SimpleOperator(String op) {
        super(op);
    }    

    public SimpleOperator(String op, Operator... child) {
        super(op, child);
    }
   
    @Override
    public boolean validValues(double value1, double value2) {
        return true;
    }

    @Override
    public boolean term() {
        return !(this.children.size() < this.limit);
    }
    
    
}
