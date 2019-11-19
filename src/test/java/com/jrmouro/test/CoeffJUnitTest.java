/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.genetic.integer.ChromosomeIntegerValidity;
import com.jrmouro.genetic.integer.CompositeStoppingCondition;
import com.jrmouro.genetic.integer.IntegerCrossover;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.coeff.CoeffOp;
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Cos;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.genetic.GenCoeffOp;
import com.jrmouro.operator.genetic.GenOp;
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
import com.jrmouro.operator.simple.VarOp;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class CoeffJUnitTest {

    @Test
    public void hello() throws IOException {
        
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
            new Exp(),   
            new Sub()
        };
        
        
        Operator[] coeffOps =  CoeffOp.getCoeffOps(cops, ops);

        Coeff[] coeffs = CoeffOp.getCoeffs((CoeffOp[]) coeffOps);

        Generator generator = new TreeGenerator(2, 6);

        ChromosomeIntegerValidity validity = new ChromosomeIntegerValidity() {

            @Override
            public boolean isRepresentationValid(List<Integer> representation) {
                
                /*Operator[] opers = new Operator[representation.size()];

                int i = 0;
                for (Integer integer : representation) {
                    int a = integer % operators.length;
                    if(operators[a].term())
                        opers[i++] = operators[a];
                    else
                        opers[i++] = operators[a].getCopy();
                }

                Operator op = generator.generate(opers);
                
                var.value = 0.0;                
                double aval0 = op.aval();
                var.value = 50.0;                
                double aval1 = op.aval();
                var.value = 100.0;                
                double aval2 = op.aval();
                
                //return aval0 <= 20.0 && aval0 >= 0.0 && aval1 <= 20.0 && aval1 >= 0.0 && aval2 <= 20.0 && aval2 >= 0.0;*/
                
                return true;
            }

        };

        Operator op = new GenOp(
                var,
                data,//data
                coeffOps,//operators
                //5,//height
                //2,//largura
                generator,
                50,//pop size
                5,// por reuse
                80,//pop limit
                validity,
                100,//chrom. size
                0,//leftBoundChromosome,
                Integer.MAX_VALUE - 1,//rightBoundChromosome,
                new CompositeStoppingCondition(3000, -0.0001),
                new IntegerCrossover(80),
                0.5,//crossoverRate,
                0.5,//mutationRate,
                0.3,//mutationRateGene,
                2// aritySelection
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
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                0.0,
                20.0).plot();

        op = new GenCoeffOp(
                data,
                var,
                coeffs,
                op,
                3000,
                50,
                0.001,
                0.5);
        
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

        new PlotOp(data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                0.0,
                20.0).plot();
        
        
        op = new GenCoeffOp(
                data,
                var,
                coeffs,
                op,
                3000,
                50,
                0.001,
                0.5);
        
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

        new PlotOp(data,
                op,
                "PolOp",
                "x",
                "y",
                0.0,
                120.0,
                0.0,
                20.0).plot();

    }
        
        

    

}
