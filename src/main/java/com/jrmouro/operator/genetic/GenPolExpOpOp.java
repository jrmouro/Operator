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
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.polynom.PolExpOpOp;

/**
 *
 * @author ronaldo
 */
public class GenPolExpOpOp  extends PolExpOpOp {

    class FitnessPolExpOpOp implements FitnessFunction<Double> {

        final double[][] dados;
        final PolExpOpOp operator;
        
        public FitnessPolExpOpOp(double[][] dados, PolExpOpOp operator) {
            this.dados = dados;
            this.operator = operator;
        }

        @Override
        public double fitness(ChromosomeAbstract<Double> chromosome) {

            for (int j = 0; j < this.operator.getCoeffs().length; j++) {
                this.operator.getCoeffs()[j].getVar().value = chromosome.getRepresentation().get(j);
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

    public GenPolExpOpOp(
            Var var,
            Coeff[] coeffs,
            Operator [] ops,
            boolean shuffle,
            double[][] dados,            
            GenCoeffOpRangeValidity validity,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, coeffs, ops, shuffle);
        
        FitnessFunction ff = new GenPolExpOpOp.FitnessPolExpOpOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validity);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff, limit).evolve(first, nrGen, true);

        System.out.println(chromosome);

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = chromosome.getRepresentation().get(j);
        }

    }
    
    
    public GenPolExpOpOp(
            Var var,
            Operator [] ops,
            boolean shuffle,
            double[][] dados,
            GenCoeffOpRangeValidity validity,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, ops, shuffle);
        
        FitnessFunction ff = new GenPolExpOpOp.FitnessPolExpOpOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validity);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff, limit).evolve(first, nrGen, true);

        System.out.println(chromosome);

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = chromosome.getRepresentation().get(j);
        }

    }

}
