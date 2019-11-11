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
public class RefOp implements Operator{
    
    Operator child;

    public RefOp(Operator child) {
        this.child = child;
    } 
        
    @Override
    public double aval() {        
                
        double v = this.child.aval();
        
        if(Double.isFinite(v))
            return v;               
        
        return 0.0;
    }
    
    @Override
    public String toString() {
        
                
        double v = this.child.aval();
        
        if(Double.isFinite(v))
            return this.child.toString();
               
        
        return "0.0";
                
    }
    
    @Override
    public boolean term() {
        return true;
    }
    
    @Override
    public void add(Operator child) {
        this.child = child;
    }

    @Override
    public Operator getCopy() {
        return new RefOp(this.child.getCopy());
    }

}

