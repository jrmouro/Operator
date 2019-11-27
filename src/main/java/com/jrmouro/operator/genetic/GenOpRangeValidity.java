/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.genetic.chromosome.ValidityRepresentation;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.generator.Generator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class GenOpRangeValidity implements ValidityRepresentation<Integer> {

    final Var var;
    final Operator[] operators;
    final Generator generator;
    final double[] dom;
    final double down, up;

    public GenOpRangeValidity(
            Var var, 
            Operator[] operators, 
            Generator generator, 
            double[] dom, 
            double down, 
            double up) {
        this.var = var;
        this.operators = operators;
        this.generator = generator;
        this.dom = dom;
        this.down = down;
        this.up = up;
    }
   

    @Override
    public boolean isValid(List<Integer> representation) {
        
        Operator[] opers = new Operator[representation.size()];

        int i = 0;
        for (Integer integer : representation) {
            int a = integer % operators.length;
            if (operators[a].term()) {
                opers[i++] = operators[a];
            } else {
                opers[i++] = operators[a].getCopy();
            }
        }

        Operator op = generator.generate(opers);

        for (double d : dom) {
            var.value = d;
            double v = op.aval();
            if(v > up || v < down )
                return false;
        }
        
        return true;
    }

}
