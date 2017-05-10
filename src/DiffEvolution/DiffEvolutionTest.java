/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffEvolution;

import data.Processor;
import function.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import population.Individual;

/**
 *
 * @author root
 */
public class DiffEvolutionTest implements Runnable{

    @Override
    public void run() {
        
        int iterations=100000;
        int experiments=30;
        int step=iterations/1000;
        int steps=iterations/step;  
        
        double bests[][]= new double[steps][experiments];
        double avgs[][]= new double[steps][experiments];
        double worsts[][]= new double[steps][experiments];
        double results[][]= new double[experiments][];
        
        
        for (int j = 0;j < experiments; j++) {
            int k=0;
            
            //Function f = new Griewank(600, 50); 
            //Function f= new Rastrigin(1000, 10);
            //Function f= new MultiDimRosenbrock(10,3);
            //Function f= new Rosenbrock(1000,5,100);
            //Function f= new CrossInTray(100);
            //Function f= new Eggholder(100);
            //Function f= new Schwefel(500,2);
            Function f= new Styblinski(500,3);
            //Function f= new Beale(4.5);

            double vector[]= f.ranDoubleVector();  

            Individual initPop[]= DEIndividual.makeRandomIndividuals(50, f);  

            DEPopulation pop= new DEPopulation(initPop, f,0.5,0.5);
            
            
            for(int i=0;i<iterations;i++) {             
            
                pop.sortPopulation();
                pop.calcAvgFitness();

                double best=pop.bestFitness();
                double avg=pop.getMedianFitness();
                double worst=pop.worstFitness(); 

                if(i%step==0){
                    bests[k][j]=best;
                    avgs[k][j]=best;
                    worsts[k][j]=best;
                    k++;
                }   
 
                pop.evolve();  

            }            
            DEIndividual bestIndividual= (DEIndividual)pop.best();
            results[j]=bestIndividual.getX();
            
        }
        
        Processor processor= new Processor(bests, avgs, worsts, results);
        
        processor.setFileName("DiffEvolution.csv");
        processor.setStep(step);
        processor.process();
        
        try {
            processor.toFile();
        } catch (IOException ex) {
            Logger.getLogger(DiffEvolutionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
