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
public class Var {
    
    public double value = 0;
    public final String nome;

    public Var(String nome) {
        this.nome = nome;
    }
    
    public Var(String nome, double value) {
        this.nome = nome;
        this.value = value;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
