/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

import com.jrmouro.operator.generator.Generator;

/**
 *
 * @author ronaldo
 */
public class Tree extends RefOp{
    
    final Generator generator;
    
    public Tree(Generator generator) {
        super(generator.generate());
        this.generator = generator;
    }

    @Override
    public Operator getCopy() {
        return new Tree(this.generator);
    }
           
    
}
