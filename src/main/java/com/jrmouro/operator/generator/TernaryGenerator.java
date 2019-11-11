/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.generator;

import com.jrmouro.operator.Operator;
import com.jrmouro.operator.Var;

/**
 *
 * @author ronaldo
 */
public class TernaryGenerator extends TreeGenerator{

    public TernaryGenerator(Integer height, Operator[] vector) {
        super(3, height, vector);
    }
    
}
