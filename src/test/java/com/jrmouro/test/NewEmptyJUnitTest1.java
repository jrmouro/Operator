/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.polynom.PolExpOpOp;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class NewEmptyJUnitTest1 {
    
    

    @Test
    public void hello() {
        
        Var var = new Var("x");
        Operator[] ops = {
            new VarOp(var),
            new Sin(new VarOp(var)),
            new ConstOp(1.0)
        };
    
        System.out.println(new PolExpOpOp(var, ops, false));
    
    }
}
