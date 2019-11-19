/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.generator;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.generator.Generator;

/**
 *
 * @author ronaldo
 */
public class Tree extends RefOp{
    
    final Generator generator;
    final Operator[] operators;
    
    public Tree(Generator generator, Operator[] operators) {
        super(generator.generate(operators));
        this.generator = generator;
        this.operators = operators;
    }

    @Override
    public Operator getCopy() {
        return new Tree(this.generator, this.operators);
    }
           
    
}
