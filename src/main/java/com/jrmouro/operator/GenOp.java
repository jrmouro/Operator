/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator;

import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.genetic.integer.ChromosomeValidity;
import com.jrmouro.genetic.integer.IntegerChromosome;
import com.jrmouro.genetic.integer.IntegerGeneticAlgorithm;
import com.jrmouro.operator.generator.Generator;
import com.jrmouro.operator.generator.TreeGenerator;
import java.io.IOException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class GenOp extends RefOp {

    Operator[] operators;
    Var var;

    public GenOp(
            Var var,
            double[][] dados,
            Operator[] ops,
            Integer heightTree,
            Integer nrChildrenTree,
            int populationSize,
            int populationReuse,
            int populationLimit,
            ChromosomeValidity validity,
            int sizeChromosome,
            int leftBoundChromosome,
            int rightBoundChromosome,
            StoppingCondition stoppingCondition,
            CrossoverPolicy crossoverPolicy,
            double crossoverRate,
            double mutationRate,
            double mutationRateGene,
            int aritySelection
    ) throws IOException {

        super(new ConstOp(0.0));

        if (dados.length > 0) {

            this.var = var;

            this.operators = new Operator[1 + ops.length];

            this.operators[0] = new VarOp(var);

            for (int i = 1; i < this.operators.length; i++) {
                this.operators[i] = ops[i-1];
            }

            FitnessFunction<Integer> fitnessFunction = new FitnessFunction<Integer>() {

                @Override
                public double fitness(ChromosomeAbstract<Integer> ca) {

                    int i = 0;

                    Operator[] opers = new Operator[ca.getRepresentation().size()];

                    for (Integer integer : ca.getRepresentation()) {
                        int a = integer % operators.length;
                        opers[i++] = operators[a].getCopy();
                    }

                    Generator g = new TreeGenerator(nrChildrenTree, heightTree, opers);

                    Operator op = g.generate();

                    Double ret = 0.0;

                    for (double[] dado : dados) {

                        var.value = dado[0];

                        double a = op.aval();

                        ret -= ((a - dado[1]) * (a - dado[1]));

                        if (Double.isNaN(ret)) {
                            return -Double.MAX_VALUE;
                        }
                        
                    }

                    return ret;
                }

            };

            IntegerGeneticAlgorithm ga = new IntegerGeneticAlgorithm(
                    populationSize,
                    populationReuse,
                    populationLimit,
                    validity,
                    fitnessFunction,
                    sizeChromosome,
                    leftBoundChromosome,
                    rightBoundChromosome,
                    stoppingCondition,
                    crossoverPolicy,
                    crossoverRate,
                    mutationRate,
                    mutationRateGene,
                    aritySelection); // selection arity

            IntegerChromosome chro = ga.run();

            Operator[] opers = new Operator[chro.getRepresentation().size()];

            int i = 0;
            for (Integer integer : chro.getRepresentation()) {
                opers[i++] = operators[integer % operators.length].getCopy();
            }

            Generator g = new TreeGenerator(nrChildrenTree, heightTree, opers);

            this.child = g.generate();

        }

    }

}
