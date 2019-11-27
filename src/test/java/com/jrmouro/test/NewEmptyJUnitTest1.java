/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Ln;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Sum;
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
        
        Var var = new Var("x", 1.0);
                
        double data[][] = new double[10][2];
        
        Operator op = new Sum(new Sin(new Ln(new VarOp(var))), new Ln(new VarOp(var)));
        
        System.out.println(op);
        
        double d = 10.0;
        for (double[] ds : data) {
            var.value = d;
            ds[0] = d;
            ds[1] = op.aval();
            d += 10.0;
            System.out.println(String.valueOf(ds[0]) + " => " + ds[1]);
        }
        
        
        
        new PlotOp(
                data,
                op,
                "Function",
                "x",
                "y",
                0.0,
                110.0,
                0.0,
                20.0).plot();
        

    
    }
}
