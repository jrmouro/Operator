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
public class Div  extends SimpleOperator{

    public Div() {
        super("/");
    }    
    
    public Div(Operator... child) {
        super("/", child);
    }

    public Div(int limit) {
        super(limit, "/", new ConstOp(1.0));
    }    
    
    public Div(int limit, Operator... child) {
        super(limit, "/", child);
    }
    
    @Override
    public boolean validValues(double value1, double value2) {
        return value2 != 0.0;
    } 
    
    @Override
    public double operate(double value1, double value2) {
        return value1 / value2;
    }

    @Override
    public Operator getCopy() {
        return new Div();
    }
            
}