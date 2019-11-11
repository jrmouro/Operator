/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.Coeff;
import com.jrmouro.operator.ConstOp;
import com.jrmouro.operator.Exp;
import com.jrmouro.operator.Mul;
import com.jrmouro.operator.Operator;
import com.jrmouro.operator.Sum;
import com.jrmouro.operator.Var;
import com.jrmouro.operator.VarOp;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class CoeffJUnitTest {

    @Test
    public void hello() {

        Coeff[] coeff = {
            new Coeff(new Var("a")),
            new Coeff(new Var("b")),
            new Coeff(new Var("c")),
            new Coeff(new Var("d")),
            new Coeff(new Var("e"))};
        
        Var x = new Var("x");
        Operator varop = new VarOp(x);
        
        Operator sum = new Sum();
        
        for (int i = 0; i < coeff.length; i++) {
            Operator mul = new Mul();
            Operator exp = new Exp();
            exp.add(new ConstOp((double)i));
            exp.add(varop);
            mul.add(exp);
            mul.add(coeff[i]);
            sum.add(mul);
        }
        
        System.out.println(sum);
        
        
    }

    



}
