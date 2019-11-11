/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.PlotOp;
import com.jrmouro.operator.PolOp;
import com.jrmouro.operator.Var;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class PolOpJUnitTest1 {
        
    @Test
    public void text() {
    
        
        PolOp op = new PolOp(new Var("x"), 3);
        
        //Operator op = new Exp();
        //op.add(new ConstOp(2.0));
        //op.add(new ConstOp(3.0));
        
        System.out.println(op);        
        System.out.println(op.aval());
        System.out.println(op.aval(10.0));
        System.out.println(op.aval());
        
        
        PlotOp plot = new PlotOp(op);
        plot.plot();
    
    }
}
