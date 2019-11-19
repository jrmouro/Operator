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
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.VarOp;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.coeff.Coeff;

/**
 *
 * @author ronaldo
 */
public class PolOp extends RefOp{
    
    final protected Coeff[] coeffs;
    final Var var;
        
    public PolOp(Var var, Integer degree) {
        super(null);
        this.var = var;
        this.coeffs = new Coeff[degree + 1];   
        
        for (int i = 0; i < degree + 1; i++) {
            coeffs[i] = new Coeff("c_" + String.valueOf(i), 1.0);
        }
        
        this.child = get(this.var, this.coeffs);
    }
    
    public PolOp(Var var, Coeff[] coeffs) {
        super(null);
        this.var = var;
        this.coeffs = coeffs;   
                
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
        
        for (int i = 0; i < coeff.length; i++) {
            Operator mul = new Mul();
            Operator exp = new Exp();
            exp.add(new ConstOp((double)i));
            exp.add(new VarOp(var));
            mul.add(exp);
            mul.add(coeff[i]);
            sum.add(mul);
        }
        
        return sum;
        
    }
    
    public static Operator get(Var var, Integer degree){
        
        Coeff [] coeffs = new Coeff[degree + 1];
        
        for (int i = 0; i < degree + 1; i++) {
            coeffs[i] = new Coeff("c_" + String.valueOf(i), 1.0);
        }
        
        return get(var, coeffs);
        
    }
    
    
     @Override
    public Operator getCopy() {
        return new PolOp(this.var, this.coeffs);
    }

    @Override
    public boolean term() {
        return true;
    }
    
}
