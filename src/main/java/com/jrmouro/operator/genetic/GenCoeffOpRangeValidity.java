/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import java.util.List;
import com.jrmouro.genetic.chromosome.ValidityGenotype;

/**
 *
 * @author ronaldo
 */
public class GenCoeffOpRangeValidity implements ValidityGenotype<Double> {

    final Var var;
    final Operator operator;
    final double[] dom;
    final double down, up;
    final Coeff[] coeffs;

    public GenCoeffOpRangeValidity(
            Var var, 
            Operator operator, 
            Coeff[] coeffs,
            double[] dom, 
            double down, 
            double up) {
        this.var = var;
        this.operator = operator;
        this.dom = dom;
        this.down = down;
        this.up = up;
        this.coeffs = coeffs;
    }
   

    @Override
    public boolean isGenotypeValid(List<Double> representation) {
        
        Operator[] opers = new Operator[representation.size()];

        int i = 0;
        for (Double d : representation) {
            this.coeffs[i++].getVar().value = d;
        }
        

        for (double d : dom) {
            var.value = d;
            double v = operator.aval();
            if(v > up || v < down || !Double.isFinite(v) )
                return false;
        }
        
        return true;
    }

}
