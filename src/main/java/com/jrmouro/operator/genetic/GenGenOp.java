/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.operator.genetic;

import com.jrmouro.operator.simple.Var;
import com.jrmouro.operator.simple.RefOp;
import com.jrmouro.operator.simple.ConstOp;
import com.jrmouro.genetic.chromosome.ChromosomeAbstract;
import com.jrmouro.genetic.chromosome.ChromosomeDouble;
import com.jrmouro.genetic.evolutionstrategies.chromosome.ChromosomeOne;
import com.jrmouro.genetic.evolutionstrategies.evolution.EvolutionScoutSniffer;
import com.jrmouro.genetic.fitnessfunction.FitnessFunction;
import com.jrmouro.genetic.integer.ChromosomeAbstractValidity;
import com.jrmouro.genetic.integer.IntegerChromosome;
import com.jrmouro.genetic.integer.IntegerGeneticAlgorithm;
import com.jrmouro.operator.coeff.Coeff;
import com.jrmouro.operator.coeff.CoeffOp;
import com.jrmouro.operator.simple.Operator;
import com.jrmouro.operator.generator.Generator;
import java.io.IOException;
import org.apache.commons.math3.genetics.CrossoverPolicy;
import org.apache.commons.math3.genetics.StoppingCondition;

/**
 *
 * @author ronaldo
 */
public class GenGenOp extends RefOp {

    //Operator[] operators;
    //Coeff[] coeffs;
    Var var;
    int count = 1;

    public GenGenOp(
            Var var,
            double[][] data,
            CoeffOp[] ops,
            Coeff[] coeffs,
            Generator generator,
            int populationSize,
            int populationReuse,
            int populationLimit,
            ChromosomeAbstractValidity<Integer> validity,
            int sizeChromosome,
            int leftBoundChromosome,
            int rightBoundChromosome,
            StoppingCondition stoppingCondition,
            CrossoverPolicy crossoverPolicy,
            double crossoverRate,
            double mutationRate,
            double mutationRateGene,
            int aritySelection,
            int nrGen,
            int sniff,
            double limit,
            double sd
    ) throws IOException {

        super(new ConstOp(0.0));

        if (data.length > 0) {

            this.var = var;

                        

            FitnessFunction<Integer> fitnessFunction = new FitnessFunction<Integer>() {

                @Override
                public double fitness(ChromosomeAbstract<Integer> ca) {

                    int i = 0;

                    Operator[] opers = new Operator[ca.getRepresentation().size()];

                    for (Integer integer : ca.getRepresentation())    
                        opers[i++] = ops[integer % ops.length].getCopy();
                                        
                    Operator op = generator.generate(opers);

                    FitnessFunction<Double> fitnessFunction = new DataOpFitnessFunction(data, var, coeffs, op);

                    double[] v = new double[coeffs.length];
                    i = 0;
                    for (Coeff coeff : coeffs) {
                        //v[i++] = coeff.getVar().value;
                        v[i++] = 1.0;
                    }

                    ChromosomeDouble first = new ChromosomeOne(v, fitnessFunction, sd);

                    ChromosomeAbstract<Double> chromosome = new EvolutionScoutSniffer(sniff, limit).evolve(first, nrGen, true);

                    /*for (int j = 0; j < coeffs.length; j++) {
                        coeffs[j].getVar().value = chromosome.getRepresentation().get(j);
                    }*/
                    
                    System.out.println("\tEA " + String.valueOf(count++) +": " + chromosome.toString());
                    //System.out.println("\tEA " + String.valueOf(count++) +": " );

                    Double ret = 0.0;

                    for (double[] dado : data) {

                        var.value = dado[0];

                        double a = op.aval();

                        ret -= ((a - dado[1]) * (a - dado[1]));

                        if (Double.isNaN(ret)) {
                            return -Double.MAX_VALUE;
                        }

                    }

                    return fitnessFunction.fitness(chromosome);
                    //return ret;
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
                    aritySelection);

            IntegerChromosome chro = ga.run();

            Operator[] opers = new Operator[chro.getRepresentation().size()];

            int i = 0;
            for (Integer integer : chro.getRepresentation()) {
                opers[i++] = ops[integer % ops.length].getCopy();
            }

            this.child = generator.generate(opers);

            System.out.println(chro);

        }

    }

}
