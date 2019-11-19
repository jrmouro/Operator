/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.genetic.integer.ChromosomeAbstractValidity;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.generator.Generator;
import java.io.IOException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class GenOpCoeffOp extends GenCoeffOp{
    
    public GenOpCoeffOp(
            Var var,
            double[][] data,                
            Operator[] ops,
            Generator generator,
            int populationSize,
            int populationReuse,
            int populationLimit,
            ChromosomeAbstractValidity<Integer> validity,
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
            double limit, 
            double sd) throws IOException {
        
        super(  data, 
                var, 
                get(ops), 
                get(
                    var,
                    data,                
                    ops,
                    generator,
                    populationSize,
                    populationReuse,
                    populationLimit,
                    validity,
                    sizeChromosome,
                    leftBoundChromosome,
                    rightBoundChromosome,
                    stoppingCondition,
                    crossoverPolicy,
                    crossoverRate,
                    mutationRate,
                    mutationRateGene,
                    aritySelection), 
                nrGen, 
                sniff, 
                limit, 
                sd);
        
    }
    
    private static Coeff[] get(Operator[] ops){
        Coeff[] ret = new Coeff[ops.length];
        for (int i = 0; i < ops.length; i++) {
            ret[i] = new Coeff(new Var("c_" + String.valueOf(i), 1.0));
            ops[i].add(ret[i]);
        }
        return ret;
    }
    
    private static Operator get(
            Var var,   
            double[][] data,
            Operator[] ops,
            Generator generator,
            int populationSize,
            int populationReuse,
            int populationLimit,
            ChromosomeAbstractValidity<Integer> validity,
            int sizeChromosome,
            int leftBoundChromosome,
            int rightBoundChromosome,
            StoppingCondition stoppingCondition,
            CrossoverPolicy crossoverPolicy,
            double crossoverRate,
            double mutationRate,
            double mutationRateGene,
            int aritySelection
    ) throws IOException{
        
        return new GenOp(
                var,
                data,//data
                ops,//operators
                generator,
                populationSize,//pop size
                populationReuse,// por reuse
                populationLimit,//pop limit
                validity,
                sizeChromosome,//chrom. size
                leftBoundChromosome,//leftBoundChromosome,
                rightBoundChromosome,//rightBoundChromosome,
                stoppingCondition,
                crossoverPolicy,
                crossoverRate,//crossoverRate,
                mutationRate,//mutationRate,
                mutationRateGene,//mutationRateGene,
                aritySelection// aritySelection
        );
        
    }
    
}
