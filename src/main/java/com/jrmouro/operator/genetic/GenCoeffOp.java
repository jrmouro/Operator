/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.chromosome.ChromosomeDouble;
import com.jrmouro.genetic.evolutionstrategies.chromosome.ChromosomeOne;
import com.jrmouro.genetic.evolutionstrategies.evolution.EvolutionScoutSniffer;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.operator.simple.Operator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class GenCoeffOp extends RefOp{
            
    public GenCoeffOp(
            double[][] data, 
            Var var, 
            Coeff[] coeffs, 
            Operator child,            
            int nrGen,
            int sniff, 
            double limit,
            double sd,
            double[] dom, 
            double down, 
            double up) 
    {
        
        super(child); 
        
        FitnessFunction<Double> fitnessFunction = new DataOpFitnessFunction(data, var, coeffs, child);
        
        double[] v = new double[coeffs.length];
        int i = 0;
        for (Coeff coeff : coeffs) {
            v[i++] = coeff.getVar().value;
        }
        
        GenCoeffOpRangeValidity validity2 = new GenCoeffOpRangeValidity(var, child, coeffs, dom, down, up);
        
        ChromosomeDouble first = new ChromosomeOne(v, fitnessFunction, sd, validity2);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff, limit).evolve(first, nrGen, true);

        System.out.println(chromosome);
        
        List<Double> repr = chromosome.getGenotype();

        for (int j = 0; j < coeffs.length; j++)
            coeffs[j].getVar().value = repr.get(j);
        
        //System.out.println(this.child);
        
        
    }
    
    
}
