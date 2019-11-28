/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.simple;

/**
 *
 * @author ronaldo
 */
public interface Operator{

    public double aval();

    public boolean term();

    public Operator getCopy();

    public void add(Operator child);    
}
