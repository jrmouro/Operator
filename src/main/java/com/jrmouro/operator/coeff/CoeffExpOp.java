/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.coeff;

import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.simple.Operator;

/**
 *
 * @author ronaldo
 */
public class CoeffExpOp extends CoeffOp{    
    
    public CoeffExpOp(Coeff coeff, Operator op) {
        super(coeff, new Exp(3), op);        
    }

    @Override
    public Operator getCopy() {
        return new CoeffExpOp(this.coeff, this.op.getCopy());
    }          
    
}
