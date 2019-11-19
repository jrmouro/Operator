/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.operator.simple.Operator;

/**
 *
 * @author ronaldo
 */
public class DataOpFitnessFunction implements FitnessFunction<Double> {
    
    final double [][] data;
    final Operator operator;
    final Coeff[] coeffs;
    final Var var;

    public DataOpFitnessFunction(double[][] data, Var var, Coeff[] coeffs, Operator operator) {
        this.data = data;
        this.operator = operator;
        this.coeffs = coeffs;
        this.var = var;
    }   
        
    @Override
    public double fitness(ChromosomeAbstract<Double> chromosome) {

        for (int j = 0; j < this.coeffs.length; j++) {
            this.coeffs[j].getVar().value = chromosome.getRepresentation().get(j);
        }

        Double ret = 0.0;

        for (double[] d : this.data) {
            
            var.value = d[0];

            double a = operator.aval();

            ret -= ((a - d[1]) * (a - d[1]));

            if (Double.isNaN(ret)) {
                return -Double.MAX_VALUE;
            }
        }

        return ret;

    }

}
