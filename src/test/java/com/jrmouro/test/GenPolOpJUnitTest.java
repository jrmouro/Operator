/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.GenPolOp;
import com.jrmouro.operator.Operator;
import com.jrmouro.operator.PlotOp;
import com.jrmouro.operator.Var;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GenPolOpJUnitTest {

    @Test
    public void test() {

        double[][] data = {
            {-2.0, -5.0},
            {-1.0, 0.0},
            {0, 1.0},
            {1.0, 4.0},
            {2.0, 15.0}
        };

        Operator op = new GenPolOp(
                new Var("x"),
                3,
                data,
                300,
                10,
                0.001,
                3.3                
        );

        System.out.println(op);
        
        PlotOp plot = new PlotOp(op);
        plot.plot();

    }
}
