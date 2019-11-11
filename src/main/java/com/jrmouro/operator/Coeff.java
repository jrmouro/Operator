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
public class Coeff extends VarOp{
    
    public Coeff(Var var) {
        super(var);
    }
    
    public Coeff(String nome, double value) {
        super(new Var(nome, value));
    }
    
     @Override
    public Operator getCopy(){
        return new Coeff(var);
    }
    
    @Override
    public String toString() {
        return String.valueOf(var.value);
    }

    
}
