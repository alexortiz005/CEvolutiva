/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffEvolution;

import function.*;
import java.util.Arrays;
import population.Individual;

/**
 *
 * @author root
 */
public class DiffEvolutionTest implements Runnable{

    @Override
    public void run() {
        
        //Function f = new Griewank(600, 50); 
        //Function f= new Rastrigin(1000, 10);
        //Function f= new MultiDimRosenbrock(10,3);
        //Function f= new Rosenbrock(1000,5,100);
        //Function f= new CrossInTray(100);
        //Function f= new Eggholder(100);
        //Function f= new Schwefel(500,2);
        Function f= new Styblinski(500,10);
        //Function f= new Beale(4.5);
        
        double vector[]= f.ranDoubleVector();  
        
        Individual initPop[]= DEIndividual.makeRandomIndividuals(50, f);  
        
        DEPopulation pop= new DEPopulation(initPop, f,0.5,0.5);
        

        
        double total=1;
        
        for(int i=0;i<100000;i++) {             
            
            pop.sortPopulation();
            pop.calcAvgFitness();
            
            double best=pop.bestFitness();
            double avg=pop.getAvgFitness();
            double worst=pop.worstFitness(); 
            
            System.out.printf("%d\t%.15f\t%.15f\t%.15f\n", i,best,avg,worst);
            
            i++;   
            pop.evolve();
            
            total=best+avg+worst;
            
        }
        
        
        System.out.println(pop.best());
        
        
    
    }
    
}
