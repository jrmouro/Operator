/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.polynom.PolExpOp;
import com.jrmouro.operator.polynom.PolOp;
import com.jrmouro.operator.simple.Var;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class PolOpJUnitTest1 {
        
    @Test
    public void text() {
    
        
        PolOp op = new PolOp(new Var("x"), 4);
        
        //Operator op = new Exp();
        //op.add(new ConstOp(2.0));
        //op.add(new ConstOp(3.0));
        
        System.out.println(op);        
        System.out.println(op.aval());
        System.out.println(op.aval(10.0));
        System.out.println(op.aval());
        
        
        PlotOp plot = new PlotOp(
                op,
                "PolOp",
                "x",
                "y",
                -5.0,
                5.0,
                -5.0,
                5.0);
        plot.plot();
        
        
        
        PolExpOp opx = new PolExpOp(new Var("x"), 4);
        
        //Operator op = new Exp();
        //op.add(new ConstOp(2.0));
        //op.add(new ConstOp(3.0));
        
        System.out.println(opx);        
        System.out.println(opx.aval());
        System.out.println(opx.aval(10.0));
        System.out.println(opx.aval());
        
        
        plot = new PlotOp(
                opx,
                "PolOp",
                "x",
                "y",
                -5.0,
                5.0,
                -5.0,
                5.0);
        plot.plot();
    
    }
}
