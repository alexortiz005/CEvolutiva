/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import function.*;
import java.util.Arrays;
import population.Individual;
import test.Test;

/**
 *
 * @author root
 */
public class HillClimbingTest extends Test {

    public HillClimbingTest(int iterations, int experiments, String outputFileName) {
        super(iterations, experiments, outputFileName);
    }

    @Override
    public void experiment(int j) {
        
        Function f = new Griewank(600, 20); 
        //Function f= new Rastrigin(1000, 10);
        //Function f= new MultiDimRosenbrock(10,3);
        //Function f= new Paraboloid(5,100);
        //Function f= new Rosenbrock(1000,5,100);
        //Function f= new CrossInTray(100);
        //Function f= new Styblinski(500,3);
        //Function f= new Beale(4.5);  

        Individual initPop[]= HCIndividual.makeRandomIndividuals(100, f);  

        HCPopulation pop= new HCPopulation(initPop, f,0.5,0.5);

        for(int i=0;i<iterations;i++) {      
            

            if(i%step==0){
                
                System.out.println(i);
                
                pop.sortPopulation();
                
                bests[k][j]=pop.bestFitness();
                avgs[k][j]=pop.getMedianFitness();
                worsts[k][j]=pop.worstFitness();
                
                k++;
                
            }   

            pop.evolve();  

        }            
        
        HCIndividual bestIndividual= (HCIndividual)pop.best();
        results[j]=bestIndividual.getX();
        
        System.out.println("Hill Climbing EXPERIMENT "+j+" FINISHED");
       
    }
    
}
