/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.generator;

import com.jrmouro.operator.simple.Operator;

/**
 *
 * @author ronaldo
 */
public class TreeGenerator implements Generator {

    final Integer height, nrChildren;
    //Operator[] vector = null;

    /*public TreeGenerator(Integer nrChildren, Integer height) {
        this.height = height;
        this.nrChildren = nrChildren;
    }*/
    
    public TreeGenerator(Integer nrChildren, Integer height) {
        this.height = height;
        this.nrChildren = nrChildren;
        //this.vector = vector;
    }

    
    
    @Override
    public Operator generate(Operator[] operators) {
        if(operators != null)
            return aux(operators, -1, 0);
        return null;
    }

    protected Operator aux(Operator[] operators, int h, int n) {
        
        Operator ret = null;
        
        if (operators != null && n < operators.length && h < this.height - 1) {

            ret = operators[n];

            if (!ret.term()) {
                
                for (int i = 0; i < this.nrChildren; i++) {
                    
                    Operator op = aux(operators, h + 1, (this.nrChildren * n) + i + 1);
                    
                    if(op != null)                    
                        ret.add(op);
                    
                }
            }

        }

        return ret;

    }


}
