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
public interface Generator {
    public Operator generate(Operator[] operators);
    //public Operator[] operators();
}
