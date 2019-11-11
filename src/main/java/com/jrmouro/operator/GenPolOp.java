/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.chromosome.ChromosomeDouble;
import com.jrmouro.genetic.evolutionstrategies.chromosome.ChromosomeTwo;
import com.jrmouro.genetic.evolutionstrategies.evolution.EvolutionScoutSniffer;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;

/**
 *
 * @author ronaldo
 */
public class GenPolOp extends PolOp {

    class FitnessPolOp implements FitnessFunction<Double> {

        final double[][] dados;
        final PolOp operator;
        
        

        public FitnessPolOp(double[][] dados, PolOp operator) {
            this.dados = dados;
            this.operator = operator;
        }

        @Override
        public double fitness(ChromosomeAbstract<Double> chromosome) {

            for (int j = 0; j < this.operator.coeffs.length; j++) {
                this.operator.coeffs[j].var.value = chromosome.getRepresentation().get(j);
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

    public GenPolOp(
            Var var,
            Integer degree,
            double[][] dados,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, degree);
        
        FitnessFunction ff = new GenPolOp.FitnessPolOp(dados, this);

        Double[] v = new Double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.var.value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff, limit).evolve(first, nrGen, true);

        System.out.println(chromosome);

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].var.value = chromosome.getRepresentation().get(j);
        }

    }

}
