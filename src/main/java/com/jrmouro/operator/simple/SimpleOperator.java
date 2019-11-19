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
    
    final protected String op;

    public SimpleOperator(String op, Operator... child) {
        super(child);
        this.op = op;
    }
   
    @Override
    public boolean validValues(double value1, double value2) {
        return true;
    }
    
    @Override
    public String stringOperate(Operator... ops) {
               
        if(ops.length == 0)
            return "";
        
        String ret = "(";
        
        int i = 0;
        
        for (; i < ops.length - 1; i++) {            
            ret += ops[i].toString() + op;
        }
        
        ret += ops[i].toString() + ")";
        
        return ret;
        
    }
    
    
}
