/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.polynom;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.VarOp;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.coeff.Coeff;

/**
 *
 * @author ronaldo
 */
public class PolExpOp extends RefOp{
    
    final protected Coeff[] coeffs;
    final Var var;
    
    public PolExpOp(Var var, Coeff[] coeffs) {
        super(null);
        this.var = var;
        this.coeffs = coeffs;          
        
        this.child = get(this.var, this.coeffs);
    }

    public PolExpOp(Var var, Integer degree) {
        super(null);
        this.var = var;
        this.coeffs = new Coeff[2 * degree + 1];   
               
        
        double d = 1.0;
        int i = 0;
        for (; i < degree; i++) {            
            coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);
            coeffs[i * 2 + 1] = new Coeff("e_" + String.valueOf(i), d);           
            d += 1.0;
        }        
        coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);
        
        
        this.child = get(this.var, this.coeffs);
    }
    
    public Coeff[] getCoeffs() {
        return coeffs;
    }

    public Var getVar() {
        return var;
    }
    
    final public double aval(double value){
        this.var.value = value;
        return this.aval();
    }
        
    public static Operator get(Var var, Coeff[] coeff){
        
                
        Operator sum = new Sum();
        
        int i = 0;
        int degree = coeff.length / 2;
        for (; i < degree; i++) { 
            Operator mul = new Mul();
            Operator exp = new Exp();
            exp.add(coeff[i * 2 + 1]);
            exp.add(new VarOp(var));
            mul.add(exp);
            mul.add(coeff[i * 2]);
            sum.add(mul);
        }
        if(i * 2 < coeff.length)
            sum.add(coeff[i * 2]);
        
        return sum;
        
    }
    
    public static Operator get(Var var, Integer degree){
        
        Coeff [] coeffs = new Coeff[2 * degree + 1];
        
        double d = 1.0;
        int i = 0;
        for (; i < degree; i++) {            
            coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);
            coeffs[i * 2 + 1] = new Coeff("e_" + String.valueOf(i), d);           
            d += 1.0;
        }        
        coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);
        
        
        return get(var, coeffs);
        
    }

    @Override
    public Operator getCopy() {
        return new PolExpOp(this.var, this.coeffs);
    }

    @Override
    public boolean term() {
        return true;
    }
    
    
    
    
    
}
