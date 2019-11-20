/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.genetic.integer.ChromosomeAbstractValidity;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.generator.TreeGenerator;
import java.io.IOException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class CoeffGenOp extends GenOp {

    
    final Coeff[] coeffs;

    public CoeffGenOp(
            Coeff[] coeffs, 
            Var var, 
            double[][] dados, 
            Operator[] ops, 
            Integer heightTree,
            Integer nrChildrenTree, 
            int populationSize, 
            int populationReuse, 
            int populationLimit, 
            ChromosomeAbstractValidity validity, 
            int sizeChromosome, 
            int leftBoundChromosome, 
            int rightBoundChromosome, 
            StoppingCondition stoppingCondition, 
            CrossoverPolicy crossoverPolicy, 
            double crossoverRate, 
            double mutationRate, 
            double mutationRateGene, 
            int aritySelection) throws IOException {
        
        super(  var, 
                dados, 
                ops, 
                new TreeGenerator(nrChildrenTree, heightTree),
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
                aritySelection);
        
        this.coeffs = coeffs;
        
        
        
        
    }

    
    
    
    

}
