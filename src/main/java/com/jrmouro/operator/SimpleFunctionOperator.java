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
public abstract class SimpleFunctionOperator implements Operator{
    
    final String op;
    private Operator child;

    public SimpleFunctionOperator(String op, ConstOp child) {
        this.op = op;
        this.child = child;
    } 
    
    public abstract double operate(double value);
    
    public boolean validValue(double value){
        return true;
    }

    @Override
    public double aval() {
        
        double ret = 0.0;
        
        double v = this.child.aval();
        
        if(Double.isFinite(v) && this.validValue(child.aval()))
            ret = this.operate(v);
                       
        return ret;
    }
    
    @Override
    public String toString() {
        
        String ret = "0.0";
        
        double v = this.child.aval();
        
        if(Double.isFinite(v) && this.validValue(child.aval()))
            ret = op + "(" + this.child.toString() + ")";
               
        
        return ret;
                
    }   
   
    @Override
    public boolean term() {
        return false;
    }

    @Override
    public void add(Operator child) {
        this.child = child;
    }
    

}

