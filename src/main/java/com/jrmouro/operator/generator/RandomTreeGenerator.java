/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.generator;

import com.jrmouro.operator.Operator;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class RandomTreeGenerator extends TreeGenerator{
    
    public RandomTreeGenerator(Integer nrChildren, Integer height, Operator[] vector, Integer size) {
        super(nrChildren, height);
        Random rnd = new Random();
        this.vector = new Operator[size];
        for (int i = 0; i < size; i++) {
            int r = rnd.nextInt(vector.length);
            this.vector[i] = vector[r].getCopy();
        }
    }
    
}
