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
public class VarOp implements Operator{
    
    final protected Var var;

    public VarOp(Var var) {
        this.var = var;
    }  

    public Var getVar() {
        return var;
    }
    
    @Override
    public double aval() {
        return this.var.value;
    }
    
    @Override
    public boolean term() {
        return true;
    }

    @Override
    public void add(Operator o) {}
    
    @Override
    public Operator getCopy(){
        return new VarOp(var);
    }

    @Override
    public String toString() {
        return var.toString();
    }
    
}
