/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.coeff;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import java.util.Random;

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
        //return this.var.nome;
    }
    
    
    public static Coeff[] getCoeffs(int size){
        
        Coeff[] ret = new Coeff[size];
        
        for (int i = 0; i < size; i++)
            ret[i] = new Coeff(new Var("c_" + String.valueOf(i), 1.0));
        
        
        return ret;   
        
    }
    
    
    public static Coeff[] getCoeffs(Random rnd, int size){
        
        Coeff[] ret = new Coeff[size];
        
        for (int i = 0; i < size; i++)
            ret[i] = new Coeff(new Var("c_" + String.valueOf(i), rnd.nextDouble()));
        
        
        return ret;   
        
    }
    
    
    public static Coeff[] getCoeffs(double[] values){
        
        Coeff[] ret = new Coeff[values.length];
        
        for (int i = 0; i < values.length; i++)
            ret[i] = new Coeff(new Var("c_" + String.valueOf(i), values[i]));
        
        
        return ret;   
        
    }

    
}
