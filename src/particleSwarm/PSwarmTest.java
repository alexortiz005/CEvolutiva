/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particleSwarm;

import function.*;
import population.Individual;
import test.Test;

/**
 *
 * @author root
 */
public class PSwarmTest extends Test{

    public PSwarmTest(int iterations, int experiments, String outputFileName) {
        super(iterations, experiments, outputFileName);
    }

    @Override
    public void experiment(int j) {
        
        //Function f = new Griewank(600, 50); 
        Function f= new Rastrigin(1000, 10);
        //Function f= new MultiDimRosenbrock(10,3);
        //Function f= new Rosenbrock(100,5,100);
        //Function f= new Paraboloid(5,100);
        //Function f= new CrossInTray(100);
        //Function f= new Styblinski(500,3);
        //Function f= new Beale(4.5);

        Individual initPop[]= Particle.makeRandomParticles(150, f);  

        Swarm pop= new Swarm(initPop, f,0.729,2.05,2.05);
        
        for(int i=0;i<iterations;i++) {     
            
            pop.evolve();    
            //pop.sortPopulation();
            pop.calcAvgFitness();

            double best=pop.getGlobalFitness();
            double avg=pop.getAvgFitness();        

            
             if(i%step==0){
                bests[k][j]=best;
                avgs[k][j]=avg;
                worsts[k][j]=0;                
                k++;
            }              
            
        }   
        
        results[j]=pop.getGlobal();
        
        System.out.println("Particle Swarm EXPERIMENT "+j+" FINISHED");
        
    }

   
    
}
