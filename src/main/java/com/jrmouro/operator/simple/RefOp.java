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
public class RefOp implements Operator{
    
    protected Operator child = null;

    public RefOp() {} 
    
    public RefOp(Operator child) {
        this.child = child;
    } 
        
    @Override
    public double aval() {         
        if(this.child == null)
            return 0.0;        
        return this.child.aval();        
    }
    
    @Override
    public String toString() {        
        if(this.child == null)
            return "0.0";        
        return this.child.toString();                
    }
    
    @Override
    public boolean term() {
        if(this.child == null)
            return false;        
        return this.child.term();
    }
    
    @Override
    public void add(Operator child) {        
        if(this.child == null)
            this.child = child;
        else
            this.child.add(child);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new RefOp(this.child.getCopy());
        return new RefOp();
    }

}

