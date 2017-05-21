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

    public double getOmega() {
        return omega;
    }

    public void setOmega(double omega) {
        this.omega = omega;
    }

    public double getPhi_p() {
        return phi_p;
    }

    public void setPhi_p(double phi_p) {
        this.phi_p = phi_p;
    }

    public double getPhi_g() {
        return phi_g;
    }

    public void setPhi_g(double phi_g) {
        this.phi_g = phi_g;
    }
    
    

    @Override
    public void evolve() {
        
        int S= this.size();
        int n= this.getFunction().getDimension();       
        
        for (int i = 0; i < S; i++) {
            
            Particle particle= (Particle) this.get(i);
            double x[]=particle.getX();
            double p[]=particle.getP();
            double v[]=new double[n];      
            double g[]=this.getGlobal().getP();
            
            for (int d = 0; d < n; d++) {
                double r_p= ran.nextDouble();
                double r_g= ran.nextDouble();
                v[d]=omega*v[d]+phi_p*r_p*(p[d]-x[d])+phi_g*r_g*(g[d]-v[d]);   
                x[d]=x[d]+v[d];
            }
            
            particle.setSpeed(v);
            particle.setX(x);
            
            if(function.calculate(x)<particle.getFitness()){
                particle.setP(x);
                particle.calcularFitness(function);                
            }
            
            if(particle.getFitness()<global.getFitness())
                global=particle;           
            
        }
        
    }
    
    
    
}
