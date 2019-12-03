/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.genetic.GenCoeffOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.polynom.PolExpOp;
import com.jrmouro.operator.simple.Var;
import org.junit.Test;
/**
 *
 * @author ronaldo
 */
public class GenCoeffOpJUnitTest {

    @Test
    public void test() {

        double[][] data = {
            {0.0, 0.0},
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

        Coeff[] coeffs = {
            new Coeff(new Var("c_0", 1.0)),
            new Coeff(new Var("c_1", 2.0)),
            new Coeff(new Var("c_2", 3.0)),
            new Coeff(new Var("c_3", 4.0)),
            new Coeff(new Var("c_4", 5.0)),
            new Coeff(new Var("c_5", -5.0)),
            new Coeff(new Var("c_6", -4.0)),
            new Coeff(new Var("c_7", -3.0)),
            new Coeff(new Var("c_8", -2.0)),
            new Coeff(new Var("c_9", -1.0))
        };

        Var var = new Var("x");

        Operator op = new PolExpOp(var, coeffs);
        
        System.out.println(op);
        
        double[] dom = {10.0, 50.0, 100.0};
        
        new PlotOp(
                data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                0.0,
                120.0).plot();
        
        op = new GenCoeffOp(
                data,
                var,
                coeffs,
                op,
                3000,
                50,
                0.0001,
                0.5, 
                dom, 
                0, 
                20.0);
        
        System.out.println(op);
        
        new PlotOp(
                data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                0.0,
                120.0).plot();

    }
}
