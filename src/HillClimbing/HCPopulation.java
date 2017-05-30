/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import function.Function;
import population.Individual;
import population.Population;
import population.RealPopulation;

/**
 *
 * @author root
 */
public class HCPopulation extends RealPopulation {

    public HCPopulation(Individual[] individuals, Function function, double crossProb, double mutProb) {
        super(individuals, function, crossProb, mutProb);
    }

    @Override
    public void evolve() {
        
        for (int i = 0; i < individuals.length; i++) {
            ((HCIndividual)individuals[i]).evolve();   
            ((HCIndividual)individuals[i]).calcularFitness(function);
        }
    
    }

}
