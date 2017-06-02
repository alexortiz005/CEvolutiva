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
        
        //Function f = new Griewank(600, 20); 
        //Function f= new Rastrigin(1000, 10);
        //Function f= new MultiDimRosenbrock(10,3);
        //Function f= new Rosenbrock(100,5,100);
        //Function f= new Paraboloid(5,100);
        //Function f= new CrossInTray(100);
        Function f= new Styblinski(5,10);
        //Function f= new Beale(4.5);

        Individual initPop[]= Particle.makeRandomParticles(100, f);  

        Swarm pop= new Swarm(initPop, f,0.729,2.025,2.025);
        
        for(int i=0;i<iterations;i++) {     
            
            pop.evolve();    
            
            
            if(i%step==0){
                pop.calcAvgFitness();
                bests[k][j]=pop.getGlobalFitness();
                avgs[k][j]=pop.getAvgFitness();
                worsts[k][j]=0;                
                k++;
            }              
            
        }   
        
        results[j]=pop.getGlobal();
        
        System.out.println("Particle Swarm EXPERIMENT "+j+" FINISHED");
        
        
    }

   
    
}
