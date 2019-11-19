/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.simple;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.plot.Plottable;

/**
 *
 * @author ronaldo
 */
public interface Operator{

    public double aval();

    public boolean term();

    public Operator getCopy();

    public void add(Operator child);    
    
    public static boolean inRange(double[] x, Var var, Operator op, double down, double up) {

        for (int i = 0; i < x.length; i++)
            if(!Operator.inRange(x[i],var,op,down,up))
                return false;

        return true;

    }

    public static boolean inRange(double x, Var var, Operator op, double down, double up) {

        var.value = x;
        double v = op.aval();
        if(!Double.isFinite(v) && v > up && v < down)
            return false;

        return true;

    }

}
