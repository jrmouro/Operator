/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.coeff;

import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Operator;

/**
 *
 * @author ronaldo
 */
public class CoeffMulOp extends CoeffOp{    
    
    public CoeffMulOp(Coeff coeff, Operator op) {
        super(coeff, new Mul(), op);        
    }

    @Override
    public Operator getCopy() {
        return new CoeffMulOp(this.coeff, this.op.getCopy());
    }          
    
}
