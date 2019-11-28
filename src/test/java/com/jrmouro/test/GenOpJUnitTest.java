/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.genetic.integer.CompositeStoppingCondition;
import com.jrmouro.genetic.integer.IntegerCrossover;
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Cos;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.Ln;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.plot.PlotOp;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Sub;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.generator.TreeGenerator;
import com.jrmouro.operator.genetic.GenOp;
import com.jrmouro.operator.genetic.GenOpRangeValidity;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GenOpJUnitTest {

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

        double[][] data3 = {
            {1.0, 2.0},
            {2.0, 3.0},
            {3.0, 5.0},
            {4.0, 7.0},
            {5.0, 11.0},
            {6.0, 13.0},
            {7.0, 17.0},
            {8.0, 19.0},
            {9.0, 23.0},
            {10.0, 29.0},
            {11.0, 31.0},
            {12.0, 37.0},
            {13.0, 41.0},};

        double[][] data4 = {
            {1.0, 2.0},
            {2.0, 3.0},
            {3.0, 5.0},
            {5.0, 7.0},
            {7.0, 11.0},
            {11.0, 13.0},
            {13.0, 17.0},
            {17.0, 19.0},
            {19.0, 23.0},
            {23.0, 29.0},
            {29.0, 31.0},
            {31.0, 37.0},
            {37.0, 41.0},};

        double[][] data5 = {
            {1.0, 1.0},
            {2.0, 2.0},
            {3.0, 2.0},
            {4.0, 4.0},
            {5.0, 2.0},
            {6.0, 4.0},
            {7.0, 2.0},
            {8.0, 4.0},
            {9.0, 6.0},
            {10.0, 2.0},
            {11.0, 6.0},
            {12.0, 4.0},
            {13.0, 6.0},};

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
        
        double[] dom = {10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0};

        Generator generator = new TreeGenerator(2, 8);
        
        Operator[] opsGen = new Operator[10];

        for (int i = 0; i < 10; i++) {

            opsGen[i] = new GenOp(
                    var,
                    data,//data
                    //coeffs,
                    ops,//operators
                    generator,
                    20,//pop size
                    1,// por reuse
                    20,//pop limit
                    new GenOpRangeValidity(var, ops, generator, dom, 0, 20.0),
                    200,//chrom. size
                    0,//leftBoundChromosome,
                    Integer.MAX_VALUE - 1,//rightBoundChromosome,
                    new CompositeStoppingCondition(3000, -0.0001),
                    new IntegerCrossover(50),
                    0.8,//crossoverRate,
                    0.5,//mutationRate,
                    0.7,//mutationRateGene,
                    2
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
