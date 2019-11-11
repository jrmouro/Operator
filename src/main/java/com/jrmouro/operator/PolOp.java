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
public class PolOp extends RefOp{
    
    final Coeff[] coeffs;
    final Var var;
    
    /*public PolOp(Var var, Coeff[] coeffs) {
        super(PolOp.get(var, coeffs));
        this.var = var;
        this.coeffs = coeffs;
    }*/
    
    public PolOp(Var var, Integer degree) {
        super(null);
        //this.var = new Var("x");
        this.var = var;
        this.coeffs = new Coeff[degree + 1];        
        for (int i = 0; i < degree + 1; i++) {
            coeffs[i] = new Coeff("c_" + String.valueOf(i), 1.0);
        }
        this.child = get(this.var, this.coeffs);
    }
        

    public Coeff[] getCoeff() {
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
        
        //Operator varop = new VarOp(var);
        
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
    
}
