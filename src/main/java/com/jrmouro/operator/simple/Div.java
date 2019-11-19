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
public class Div  extends SimpleOperator{

    public Div() {
        super("/", new ConstOp(1.0));
    }    
    
    public Div(Operator... child) {
        super("/", child);
    }

    @Override
    public boolean validValues(double value1, double value2) {
        return value2 != 0.0;
    }
        
    
    @Override
    public double operate(double value1, double value2) {
        if(value2 == 0.0)
            return value1;
        return value1 / value2;
    }

    @Override
    public Operator getCopy() {
        return new Div();
    }
    
    @Override
    final public String stringOperate(Operator... ops) {
               
        if(ops.length == 0)
            return "";
        
        String ret = "(" + ops[0].toString();
        
        int i = 1;       
        
        for (; i < ops.length - 1; i++) {    
            if(ops[i].aval() != 0.0)
                ret += op + ops[i].toString();
        }
        
        if(i < ops.length && ops[i].aval() != 0.0)
            ret += op + ops[i].toString() + ")";
        else
            ret += ")";
        
        return ret;
        
    }
    
}