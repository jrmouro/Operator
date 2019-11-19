/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.test;

import com.jrmouro.operator.generator.BinaryTreeGenerator;
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.operator.simple.Div;
import com.jrmouro.operator.simple.Exp;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.simple.Ln;
import com.jrmouro.operator.simple.Log;
import com.jrmouro.operator.simple.Mul;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.Sin;
import com.jrmouro.operator.simple.Sub;
import com.jrmouro.operator.simple.Sum;
import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.VarOp;
import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.FunctionPlottable;
import com.jrmouro.plot.Plottable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class NewEmptyJUnitTest {
    
    @Test
    public void hello() throws IOException {
        
        Var var = new Var("x");
    
        Operator [] ops = {            
            new Sum(),
            new Mul(),
            new Sub(),
            new Mul(),
            new Exp(),
            new VarOp(var),
            new Sum(),
            new ConstOp(2.0),
            new Sum(),
            new Sin(),
            new Mul(),
            new Exp(),
            new Sin(),
            new ConstOp(1.0),
            new Sum(),
            new Div(),
            new Ln(),
            new Log(),
            new Sin(),
            new Exp(),
            new ConstOp(1.0),
            new Mul(),
            new ConstOp(2.0),
            new Sum(),
            new Mul(),
            new ConstOp(1.0),
            new VarOp(var),
            new Sum()            
        };
        
        Collections.shuffle(Arrays.asList(ops));
        
        Generator ge = new BinaryTreeGenerator(8);
        
        Operator po = ge.generate(ops);
        
        System.out.println(po);
        System.out.println("x = 0 -> " + po.aval());
        var.value = 1.0;
        System.out.println("x = 1 -> " + po.aval());
        var.value = 0.5;
        System.out.println("x = .5 -> " + po.aval());
        
        List<String> sets = new ArrayList();        
                
        sets.add("title 'Test'");
        sets.add("xlabel 'time'");
        sets.add("ylabel 'volume'");
        sets.add("grid");
        sets.add("xrange [0:100]");
        sets.add("yrange [0:20]");
    
        Plottable p = new FunctionPlottable(po.toString(), sets, CanonicalPath.getPath("test.plot"));
        p.plot();
        
        
    
    }
}
