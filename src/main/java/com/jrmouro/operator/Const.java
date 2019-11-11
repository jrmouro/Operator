/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

/**
 *
 * @author ronaldo
 */
public class Const {
    
    public final double value;
    public final String nome;
        
    public Const(String nome, double value) {
        this.nome = nome;
        this.value = value;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
