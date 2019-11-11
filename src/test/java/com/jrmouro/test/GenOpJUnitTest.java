/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.genetic.integer.ChromosomeIntegerValidity;
import com.jrmouro.genetic.integer.CompositeStoppingCondition;
import com.jrmouro.genetic.integer.VectorPointsIntegerCrossover;
import com.jrmouro.operator.ConstOp;
import com.jrmouro.operator.Cos;
import com.jrmouro.operator.Div;
import com.jrmouro.operator.Exp;
import com.jrmouro.operator.GenOp;
import com.jrmouro.operator.Ln;
import com.jrmouro.operator.Log;
import com.jrmouro.operator.Mul;
import com.jrmouro.operator.Operator;
import com.jrmouro.operator.PlotOp;
import com.jrmouro.operator.Sin;
import com.jrmouro.operator.Sub;
import com.jrmouro.operator.Sum;
import com.jrmouro.operator.Var;
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

        Operator[] ops = {
            new Sum(),
            new Mul(),
            new Div(),
            new Sub(),
            new Exp(),
            new ConstOp(2.0),
            new Sin(),
            new Cos(),
            new ConstOp(-1.0),
            new Ln(),
            new Log()
        };

        Var var = new Var("x");
        
        Operator op = new GenOp(
                var,
                data,//data
                ops,//operators
                5,//height
                2,//largura
                50,//pop size
                5,// por reuse
                50,//pop limit
                new ChromosomeIntegerValidity(),
                40,//chrom. size
                0,//leftBoundChromosome,
                Integer.MAX_VALUE - 1,//rightBoundChromosome,
                new CompositeStoppingCondition(300, -0.1),
                new VectorPointsIntegerCrossover(100, 1),
                0.5,//crossoverRate,
                0.5,//mutationRate,
                0.3,//mutationRateGene,
                2// aritySelection
        );
        
        
        System.out.println(op);
        
        PlotOp plot = new PlotOp(op);
        plot.plot();

    }
}
