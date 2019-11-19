/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.polynom.PolExpOpOp;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronaldo
 */
public class NewEmptyJUnitTest1 {
    
    public NewEmptyJUnitTest1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        
        Var var = new Var("x");
        Operator[] ops = {
            new VarOp(var),
            new Sin(new VarOp(var)),
            new ConstOp(1.0)
        };
    
        System.out.println(new PolExpOpOp(var, ops, false));
    
    }
}
