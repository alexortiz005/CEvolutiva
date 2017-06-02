/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffEvolution;

import function.*;
import population.Individual;
import test.Test;

/**
 *
 * @author root
 */
public class DiffEvolutionTest extends Test{    

    public DiffEvolutionTest(int iterations, int experiments, String outputFileName) {
        super(iterations, experiments, outputFileName);
    }

    @Override
    public void experiment(int j) {
        
        //Function f = new Griewank(600, 20); 
        //Function f= new Rastrigin(1000, 10);
        //Function f= new MultiDimRosenbrock(10,3);
        //Function f= new Paraboloid(5,100);
        //Function f= new Rosenbrock(1000,5,100);
        //Function f= new CrossInTray(100);
        Function f= new Styblinski(500,10);
        //Function f= new Beale(4.5);  

        Individual initPop[]= DEIndividual.makeRandomIndividuals(50, f);  

        DEPopulation pop= new DEPopulation(initPop, f,0.5,0.5);

        for(int i=0;i<iterations;i++) {         

            if(i%step==0){
                
                pop.sortPopulation();
                pop.calcAvgFitness();
                
                bests[k][j]=pop.bestFitness();
                avgs[k][j]=pop.getMedianFitness();
                worsts[k][j]=pop.worstFitness();
                k++;
            }   

            pop.evolve();  

        }            
        DEIndividual bestIndividual= (DEIndividual)pop.best();
        results[j]=bestIndividual.getX();
        
        System.out.println("Differential Evolution EXPERIMENT "+j+" FINISHED");
        
    }
    
    
}
