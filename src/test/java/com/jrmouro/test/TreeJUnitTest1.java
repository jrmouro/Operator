/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.ConstOp;
import com.jrmouro.operator.Div;
import com.jrmouro.operator.Exp;
import com.jrmouro.operator.Ln;
import com.jrmouro.operator.Log;
import com.jrmouro.operator.Mul;
import com.jrmouro.operator.Operator;
import com.jrmouro.operator.Sin;
import com.jrmouro.operator.Sub;
import com.jrmouro.operator.Sum;
import com.jrmouro.operator.Var;
import com.jrmouro.operator.VarOp;
import com.jrmouro.operator.generator.BinaryTreeGenerator;
import com.jrmouro.operator.generator.Generator;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class TreeJUnitTest1 {
    
    @Test
    public void test() {
        
        Var var = new Var("x");
        
        var.value = 1;
        
        Operator [] ops = {    
            new Mul(),
             new Sum(),
            new Ln(),            
            new ConstOp(2.0),
            new VarOp(var),
            new Mul(),
            new Sub(),
            new Mul(),
            new Exp(),
            new VarOp(var),
            new Sum(),
            new ConstOp(2.0),
            new Sum(),
            new Sin(),
            new Mul(),
            new Exp(),
            new Sin(),
            new ConstOp(1.0),
            new Sum(),
            new Div(),
            new Ln(),
            new Log(),
            new Sin(),
            new Exp(),
            new ConstOp(1.0),
            new Mul(),
            new ConstOp(2.0),
            new Sum(),
            new Mul(),
            new ConstOp(1.0),
            new VarOp(var),
            new Sum()            
        };
        
    
        Generator g = new BinaryTreeGenerator(5, ops);
        
        System.out.println(g.generate());
        
        
    }
}
