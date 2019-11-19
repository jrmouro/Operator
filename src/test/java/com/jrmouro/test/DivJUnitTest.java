/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Mod;
import com.jrmouro.operator.simple.Operator;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class DivJUnitTest {
    
    @Test
    public void test() {
    
        Operator op = new Div();
        System.out.println(op);
        op.add(new ConstOp(0.0));
        op.add(new ConstOp(-2.0));
        op.add(new ConstOp(0.0));
        op.add(new ConstOp(3.0));
        
        System.out.println(new Mod(op));
        System.out.println(new Mod(op).aval());
    
    }
}
