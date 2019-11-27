/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.genetic.chromosome.ValidityRepresentation;
import com.jrmouro.operator.genetic.GenPolExpOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.simple.Var;
import java.util.List;
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

        Var var = new Var("x", 1.0);

        Operator op = new GenPolExpOp(
                var,
                1,
                data,
                new ValidityRepresentation<Double>() {
                    @Override
                    public boolean isValid(List<Double> representation) {
                        return true;
                    }
                    
                },
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
                0.0,
                20.0);
        plot.plot();

    }
}
