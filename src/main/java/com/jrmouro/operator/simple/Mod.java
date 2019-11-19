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
public class Mod extends RefOp{
    
    public Mod() {}
    
    public Mod(Operator child) {
        super(child);
    }

    @Override
    public Operator getCopy() {
        if(this.child != null)
            return new Mod(this.child.getCopy());
        return new Mod();
    }

    @Override
    public String toString() {
        double ret = super.aval();
        if(ret < 0.0)
            return "(-1.0*" + super.toString() + ")";
        return super.toString();
    }

    @Override
    public double aval() {
        double ret = super.aval();
        if(ret < 0.0)
            return -1.0 * ret;
        return ret;
    }
      
    
}
