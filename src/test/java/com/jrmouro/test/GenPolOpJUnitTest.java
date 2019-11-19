/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Cos;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.genetic.GenPolExpOp;
import com.jrmouro.operator.genetic.GenPolExpOpOp;
import com.jrmouro.operator.genetic.GenPolOp;
import com.jrmouro.operator.simple.Ln;
import com.jrmouro.operator.simple.Mod;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Sub;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GenPolOpJUnitTest {

    @Test
    public void test() {

        double[][] data = {
            {10, 6.36},
            {20, 9.9},
            {30, 9.22},
            {40, 11.81},
            {50, 11.47},
            {60, 11.98},
            {70, 13.52},
            {80, 12.15},
            {90, 14.39},
            {100, 13.31}
        };

        Operator op = new GenPolOp(
                new Var("x"),
                7,
                data,
                300,
                50,
                0.0001,
                0.5                
        );

        System.out.println(op);
        
        PlotOp plot = new PlotOp(
                data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                -120.0,
                120.0);
        plot.plot();
        
        op = new GenPolExpOp(
                new Var("x"),
                2,
                data,
                300,
                50,
                0.0001,
                0.5                
        );

        System.out.println(op);
        
        plot = new PlotOp(
                data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                -120.0,
                120.0);
        plot.plot();
        
        
        Var var = new Var("x", 1.0);
        
        Operator[] ops = {
            new VarOp(var),            
            /*new GenPolExpOp(
                var,
                3,
                data,
                300,
                50,
                0.0001,
                0.5                
            ),*/
            new VarOp(var),
            //new Sum(new VarOp(var),  new ConstOp(2.0)),
            //new Sum(new Sin(new VarOp(var)),new VarOp(var), new ConstOp(2.0)),
            //new Mul(),
           // new Div(),
           // new Sub(),
           // new Mod(new VarOp(var)),
            //new ConstOp(2.0),
            //new Sin(new Va//new ConstOp(2.0)rOp(var)),
            //new Cos(new VarOp(var)),
            //new Cos(new VarOp(var)),
            //new ConstOp(2.//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)//new ConstOp(2.0)0),
            //new Ln(new VarOp(var))
        };
        
        
        op = new GenPolExpOpOp(
                var,
                ops,
                false,
                data,
                300,
                50,
                0.0001,
                0.5                
        );

        System.out.println(op);
        
        plot = new PlotOp(
                data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                -120.0,
                120.0);
        
        plot.plot();

    }
}
