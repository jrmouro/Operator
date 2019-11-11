/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

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

    public PlotOp(double[][] points, Operator child) {
        super(child);
        this.points = points;
    }

    public PlotOp(Operator child) {
        super(child);
    }

    @Override
    public void plot() {

        Plottable p = null;

        List<String> sets = new ArrayList();
        sets.add("title 'Test'");
        sets.add("xlabel 'time'");
        sets.add("ylabel 'volume'");
        sets.add("grid");
        sets.add("xrange [-10:10]");
        sets.add("yrange [-10:10]");
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
