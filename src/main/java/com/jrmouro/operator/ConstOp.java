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
public class ConstOp implements Operator{
    
    final double c;
    final Const _const;

    public ConstOp(double c) {
        this.c = c;
        this._const = null;
    }
    
    public ConstOp(Const c) {
        this._const = c;
        this.c = 0.0;
    }
    
    @Override
    public double aval() {
        if(this._const != null)
            return this._const.value;
        return c;
    }

    @Override
    public boolean term() {
        return true;
    }

    @Override
    public Operator getCopy() {
        if(this._const != null)
            return new ConstOp(this._const);
        return new ConstOp(c);
    }

    @Override
    public void add(Operator child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        if(this._const != null)
            return this._const.toString();
        return String.valueOf(c);
    }   
    
}
