/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class DivJUnitTest {
    
    @Test
    public void test() {
        
        Var x = new Var("x", 1.0);
    
        Operator op = new Sin(new VarOp(x));
        System.out.println(op);
        
        op.add(new ConstOp(0.0));
        op.add(new ConstOp(-2.0));
        op.add(new ConstOp(0.0));
        //op.add(new ConstOp(3.0));
        
        System.out.println(op);
        System.out.println(op.aval());
    
    }
}
