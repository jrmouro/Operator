/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.chromosome.ChromosomeDouble;
import com.jrmouro.genetic.chromosome.ChromosomeValidity;
import com.jrmouro.genetic.evolutionstrategies.chromosome.ChromosomeTwo;
import com.jrmouro.genetic.evolutionstrategies.evolution.EvolutionScoutSniffer;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.operator.polynom.PolExpOp;
import java.util.List;
import com.jrmouro.genetic.chromosome.ValidityGenotype;

/**
 *
 * @author ronaldo
 */
public class GenPolExpOp  extends PolExpOp {

    class FitnessPolExpOp implements FitnessFunction<Double> {

        final double[][] dados;
        final PolExpOp operator;
        
        public FitnessPolExpOp(double[][] dados, PolExpOp operator) {
            this.dados = dados;
            this.operator = operator;
        }

        @Override
        public double fitness(ChromosomeAbstract<Double> chromosome) {
            
            List<Double> repr = chromosome.getGenotype();

            for (int j = 0; j < this.operator.getCoeffs().length; j++) {
                this.operator.getCoeffs()[j].getVar().value = repr.get(j);
            }
            
            Double ret = 0.0;

            for (double[] dado : dados) {

                double a = operator.aval(dado[0]);

                ret -= ((a - dado[1]) * (a - dado[1]));

                if (Double.isNaN(ret)) {
                    return -Double.MAX_VALUE;
                }
            }

            return ret;

        }

    }

    public GenPolExpOp(
            Var var,
            Coeff[] coeffs,
            double[][] dados,
            ValidityGenotype<Double> validityRepresentation,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, coeffs);
        
        FitnessFunction ff = new GenPolExpOp.FitnessPolExpOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validityRepresentation);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff/*, limit*/).evolve(first, nrGen, true);

        System.out.println(chromosome);
        
        List<Double> repr = chromosome.getGenotype();

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = repr.get(j);
        }

    }
    
    
    public GenPolExpOp(
            Var var,
            Integer degree,
            double[][] dados,
            ValidityGenotype<Double> validityRepresentation,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, degree);
        
        FitnessFunction ff = new GenPolExpOp.FitnessPolExpOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validityRepresentation);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff/*, limit*/).evolve(first, nrGen, true);

        System.out.println(chromosome);

        List<Double> repr = chromosome.getGenotype();
        
        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = repr.get(j);
        }

    }

}
