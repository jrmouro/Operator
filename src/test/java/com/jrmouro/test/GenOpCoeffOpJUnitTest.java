/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.genetic.integer.CompositeStoppingCondition;
import com.jrmouro.genetic.integer.IntegerCrossover;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.coeff.CoeffOp;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.generator.TreeGenerator;
import com.jrmouro.operator.genetic.GenOpCoeffOp;
import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Cos;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.Ln;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Sub;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GenOpCoeffOpJUnitTest {

    @Test
    public void test() throws IOException {

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

       double[] dom = {10.0, 50.0, 100.0};

        Var var = new Var("x");

        Operator[] ops = {
            new Sum(),
            new Mul(),
            new Div(),
            new Sub(),
            new Exp(),
            new Sin(),
            new Cos(),
            new Ln(),
            new VarOp(var),
            new ConstOp(-1.0),
            new ConstOp(0.1),
            new ConstOp(2.0)

        };

        Operator[] cops = {
            new Sum(),
            new Mul(),
            new Exp()};

        Generator generator = new TreeGenerator(2, 5);

        Operator[] opsGen = new Operator[10];

        for (int i = 0; i < 10; i++) {

            CoeffOp[] coeffOps = CoeffOp.getCoeffOps(cops, ops);

            Coeff[] coeffs = CoeffOp.getCoeffs((CoeffOp[]) coeffOps);

            List<Operator> list = new ArrayList();
            list.addAll(Arrays.asList(ops));
            list.addAll(Arrays.asList(coeffOps));

            ops = new Operator[list.size()];
            ops = list.toArray(ops);

            opsGen[i] = new GenOpCoeffOp(
                    data,//data
                    var,
                    coeffs,
                    ops,//operators
                    generator,
                    200,//pop size
                    1,// por reuse
                    200,//pop limit
                    200,//chrom. size
                    0,//leftBoundChromosome,
                    Integer.MAX_VALUE - 1,//rightBoundChromosome,
                    new CompositeStoppingCondition(1000, -0.0001),
                    new IntegerCrossover(50),
                    0.8,//crossoverRate,
                    0.5,//mutationRate,
                    0.7,//mutationRateGene,
                    2,
                    1000,
                    100,
                    0.00001,
                    0.5,
                    dom,
                    0.0,
                    20.0
            );

            System.out.println(opsGen[i]);

            new PlotOp(
                    data,
                    opsGen[i],
                    "Function",
                    "x",
                    "y",
                    0.0,
                    110.0,
                    0.0,
                    20.0).plot();

        }

    }
}
