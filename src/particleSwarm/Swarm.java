/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particleSwarm;

import function.Function;
import population.Individual;
import population.RealPopulation;

/**
 *
 * @author root
 */
public class Swarm extends RealPopulation{   
    
    Particle global;  
    double omega;
    double phi_p;
    double phi_g;    

    public Swarm(Individual[] individuals,Function function, double omega, double phi_p,double phi_g) {
        super(individuals,function, 0, 0);    
        
        this.omega=omega;
        this.phi_p=phi_p;
        this.phi_g=phi_g;          
        
        global=(Particle)this.get(0);
        
        for (int i = 0; i < this.individuals.length; i++)   
            if(this.individuals[i].getFitness()<global.getFitness())
                global=(Particle)this.individuals[i];    
        
        
    }

    public Particle getGlobal() {
        return global;
    }

    public void setGlobal(Particle global) {
        this.global = global;
    }
    
    public double getGlobalFitness(){
        return this.global.getFitness();
    }

    @Override
    public void evolve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
