/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.simple.Operator;
import java.io.IOException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class GenOpCoeffOp extends GenCoeffOp {

    public GenOpCoeffOp(
            double[][] data,
            Var var,
            Coeff[] coeffs,
            Operator[] ops,
            Generator generator,
            int populationSize,
            int populationReuse,
            int populationLimit,
            int sizeChromosome,
            int leftBoundChromosome,
            int rightBoundChromosome,
            StoppingCondition stoppingCondition,
            CrossoverPolicy crossoverPolicy,
            double crossoverRate,
            double mutationRate,
            double mutationRateGene,
            int aritySelection,
            int nrGen,
            int sniff,
            //double limit,
            double sd,
            double[] dom, 
            double down, 
            double up) throws IOException {

        super(data,
                var,
                coeffs,
                new GenOp(
                        var,
                        data,//data
                        ops,//operators
                        generator,
                        populationSize,//pop size
                        populationReuse,// por reuse
                        populationLimit,//pop limit
                        new GenOpRangeValidity(var, ops, generator, dom, down, up),
                        sizeChromosome,//chrom. size
                        leftBoundChromosome,//leftBoundChromosome,
                        rightBoundChromosome,//rightBoundChromosome,
                        stoppingCondition,
                        crossoverPolicy,
                        crossoverRate,//crossoverRate,
                        mutationRate,//mutationRate,
                        mutationRateGene,//mutationRateGene,
                        aritySelection// aritySelection
                ),
                
                nrGen,
                sniff,
                //limit,
                sd,
                dom,
                down,
                up);

    }  

}
