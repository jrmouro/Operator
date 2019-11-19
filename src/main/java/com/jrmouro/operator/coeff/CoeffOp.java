/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.coeff;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.simple.Var;

/**
 *
 * @author ronaldo
 */
public class CoeffOp extends RefOp{
    
    final Coeff coeff;
    final Operator op;
    
    public CoeffOp(Coeff coeff, Operator coeffOp, Operator op) {
        super(coeffOp.getCopy());
        this.op = op;
        this.coeff = coeff;
        this.child.add(coeff);
        this.child.add(op);
    }
    
    @Override
    public Operator getCopy() {
        return new CoeffOp(this.coeff, this.child.getCopy(), this.op.getCopy());
    }
    
    @Override
    public boolean term() {
        return this.op.term();
    }

    @Override
    public void add(Operator child) {
        this.op.add(child);
    }  
    
    
    public static Operator[] getCoeffOps(Operator coeffOp, Operator[] op){
        
        Operator[] ret = new CoeffOp[op.length];        
        
        for (int i = 0; i < op.length; i++)            
            ret[i] = new CoeffOp(new Coeff(new Var("c_" + String.valueOf(i), 1.0)), coeffOp, op[i]);
        
        return ret;
        
    }
    
    public static Operator[] getCoeffOps(Operator coeffOp[], Operator[] op){
        
        Operator[] ret = new CoeffOp[coeffOp.length * op.length];        
        
        for (int i = 0; i < coeffOp.length; i++) 
            for (int j = 0; j < op.length; j++) 
                ret[i * op.length + j] = new CoeffOp(new Coeff(new Var("c_" + String.valueOf(i) + "_" + String.valueOf(j), 1.0)), coeffOp[i], op[j]);
        
        return ret;
        
    }
    
    
    public static Coeff[] getCoeffs(CoeffOp[] coeffOp){
        
        Coeff[] ret = new Coeff[coeffOp.length];
        
        int i = 0;
        
        for (CoeffOp co : coeffOp)
            ret[i++] = co.coeff;
        
        return ret;
    }
    
    
}
