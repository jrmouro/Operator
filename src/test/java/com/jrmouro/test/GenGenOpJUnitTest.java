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
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.generator.TreeGenerator;
import com.jrmouro.operator.genetic.GenGenOp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class GenGenOpJUnitTest {

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
            {13.0, 41.0},
        };
        
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
            {37.0, 41.0},
        };
        
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
            {13.0, 6.0},
        };
        
        Var var = new Var("x");
        
                
        double[] dom = {10.0, 50.0, 100.0};

        Operator[] ops = {
            new Sum(),
            new Mul(),
            new Div(),
            new Sub(),
            new Exp(),
            new Sin(),
            new Cos(),
            new Ln(),
           
        };
        
         Operator[] cops = {
            new Sum(),
            new Mul(),  
        };
        
        
        CoeffOp[] coeffOps =  CoeffOp.getCoeffOps(cops, ops);
        
        Coeff[] coeffs = CoeffOp.getCoeffs((CoeffOp[]) coeffOps);
        
        List<Operator> list = new ArrayList();
        list.addAll(Arrays.asList(ops));
        list.addAll(Arrays.asList(coeffOps));
        
        ops = new Operator[list.size()];
        ops = list.toArray(ops);
        

        Generator generator = new TreeGenerator(2, 5);

        
        Operator op = new GenGenOp(
                var,
                data,//data
                ops,//operators
                coeffs,
                generator,
                20,//pop size
                1,// por reuse
                20,//pop limit
                128,//chrom. size
                0,//leftBoundChromosome,
                Integer.MAX_VALUE - 1,//rightBoundChromosome,
                new CompositeStoppingCondition(50, -0.0001),
                new IntegerCrossover(10),
                0.8,//crossoverRate,
                0.5,//mutationRate,
                0.7,//mutationRateGene,
                2,// aritySelection
                50,
                20,
                0.00001,
                0.5,
                dom, 
                0.0, 
                50.0
        );

        System.out.println();
        for (double[] ds : data) {
            System.out.print(ds[0]);
            System.out.print(" : ");
            System.out.print(ds[1]);
            System.out.print(" : ");
            var.value = ds[0];
            System.out.println(op.aval());
        }
        
        System.out.println();

        System.out.println(op);

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
