/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.polynom;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.coeff.Coeff;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class PolExpOpOp extends RefOp {

    final Var var;
    final Operator[] ops;
    final protected Coeff[] coeffs;
    final boolean shuffle;

    public PolExpOpOp(Var var, Coeff[] coeffs, Operator[] ops, boolean shuffle) {
        super(null);
        this.var = var;
        this.coeffs = coeffs;
        this.ops = ops;
        this.shuffle = shuffle;

        this.child = get(this.coeffs, this.ops, shuffle);        

    }

    public PolExpOpOp(Var var, Operator[] ops, boolean shuffle) {
        super(null);
        this.var = var;
        this.ops = ops;
        this.shuffle = shuffle;
        this.coeffs = new Coeff[2 * ops.length + 1];

        double d = 1.0;
        int i = 0;
        for (; i < ops.length; i++) {
            coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);
            coeffs[i * 2 + 1] = new Coeff("e_" + String.valueOf(i), d);
            d += 1.0;
        }
        coeffs[i * 2] = new Coeff("c_" + String.valueOf(i), 1.0);

        this.child = get(this.coeffs, this.ops, shuffle);

    }
    
    final public double aval(double value){
        this.var.value = value;
        return this.aval();
    }

    public Coeff[] getCoeffs() {
        return coeffs;
    }

    public static Operator get(Coeff[] coeff, Operator[] ops, boolean shuffle) {

        Operator sum = new Sum();

        if (shuffle) {
            List<Operator> list = Arrays.asList(ops);
            Collections.shuffle(list);
            list.toArray(ops);
        }

        int i = 0;
        int degree = Math.min(coeff.length / 2, ops.length);
        for (; i < degree; i++) {
            Operator mul = new Mul();
            Operator exp = new Exp();
            exp.add(coeff[i * 2 + 1]);
            exp.add(ops[i].getCopy());
            mul.add(exp);
            mul.add(coeff[i * 2]);
            sum.add(mul);
        }

        return sum;

    }

    @Override
    public Operator getCopy() {
        return new PolExpOpOp(this.var, this.coeffs, this.ops, this.shuffle);
    }

    @Override
    public boolean term() {
        return true;
    }

}
