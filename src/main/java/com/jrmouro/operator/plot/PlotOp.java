/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.plot;

import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.FunctionPlottable;
import com.jrmouro.plot.Plottable;
import com.jrmouro.plot.PointsFunctionPlottable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo
 */
public class PlotOp extends RefOp implements Plottable {

    double[][] points = null;
    String title = "Function";
    String xLabel = "x";
    String yLabel = "f(x)";
    double xrd = 0.0;
    double xru = 1.0;
    double yrd = 0.0;
    double yru = 1.0;
    
    
    

    public PlotOp(
            double[][] points, 
            Operator child, 
            String title,
            String xLabel,
            String yLabel,
            double xrd,
            double xru,
            double yrd,
            double yru) {
        super(child);
        this.points = points;        
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.xrd = xrd;
        this.xru = xru;
        this.yrd = yrd;
        this.yru = yru;
    }

    public PlotOp(
            Operator child, 
            String title,
            String xLabel,
            String yLabel,
            double xrd,
            double xru,
            double yrd,
            double yru) {
        super(child);
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.xrd = xrd;
        this.xru = xru;
        this.yrd = yrd;
        this.yru = yru;
    }

    

    @Override
    public void plot() {

        Plottable p = null;

        List<String> sets = new ArrayList();
        sets.add("title '" + title + "'");
        sets.add("xlabel '" + xLabel + "'");
        sets.add("ylabel '" + yLabel + "'");
        sets.add("grid");
        sets.add("xrange [" + String.valueOf(this.xrd) + ":"+ String.valueOf(this.xru) + "]");
        sets.add("yrange [" + String.valueOf(this.yrd) + ":"+ String.valueOf(this.yru) + "]");
        sets.add("style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2");

        if (this.points != null) {
            try {
                p = new PointsFunctionPlottable(
                        points,
                        this.toString(),
                        sets,
                        CanonicalPath.getPath("temp.txt"),
                        CanonicalPath.getPath("temp.plot"));
            } catch (IOException ex) {
                Logger.getLogger(PlotOp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            List<String> functions = new ArrayList();
            functions.add(this.toString());

            try {
                p = new FunctionPlottable(functions, sets, CanonicalPath.getPath("temp.plot"));
            } catch (IOException ex) {
                Logger.getLogger(PlotOp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        p.plot();

    }

}
