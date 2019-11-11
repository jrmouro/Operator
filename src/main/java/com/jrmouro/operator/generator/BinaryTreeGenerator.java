/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.generator;

import com.jrmouro.operator.Operator;

/**
 *
 * @author ronaldo
 */
public class BinaryTreeGenerator extends TreeGenerator{

    public BinaryTreeGenerator(Integer height, Operator[] vector) {
        super(2, height, vector);
    }
    
}