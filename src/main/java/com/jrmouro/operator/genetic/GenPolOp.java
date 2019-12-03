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
import com.jrmouro.genetic.evolutionstrategies.chromosome.ChromosomeTwo;
import com.jrmouro.genetic.evolutionstrategies.evolution.EvolutionScoutSniffer;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.operator.polynom.PolOp;
import java.util.List;

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

    public GenPolOp(
            Var var,
            Coeff[] coeffs,
            double[][] dados,            
            GenCoeffOpRangeValidity validity,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, coeffs);
        
        FitnessFunction ff = new GenPolOp.FitnessPolOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validity);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff/*, limit*/).evolve(first, nrGen, true);

        System.out.println(chromosome);
        
        List<Double> repr = chromosome.getGenotype();

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = repr.get(j);
        }

    }
    
    
    public GenPolOp(
            Var var,
            Integer degree,
            double[][] dados,
            GenCoeffOpRangeValidity validity,
            int nrGen,
            int sniff, 
            double limit,
            double sd
            
    ) {

        super(var, degree);
        
        FitnessFunction ff = new GenPolOp.FitnessPolOp(dados, this);

        double[] v = new double[this.coeffs.length];
        int i = 0;
        for (Coeff coeff : this.coeffs) {
            v[i++] = coeff.getVar().value;
        }

        ChromosomeDouble first = new ChromosomeTwo(v, ff, sd, validity);

        ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff/*, limit*/).evolve(first, nrGen, true);

        System.out.println(chromosome);
        
        List<Double> repr = chromosome.getGenotype();

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = repr.get(j);
        }

    }

}
