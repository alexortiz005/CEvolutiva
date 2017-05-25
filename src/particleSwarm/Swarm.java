/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particleSwarm;

import function.Function;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import population.Individual;
import population.RealPopulation;

/**
 *
 * @author root
 */
public class Swarm extends RealPopulation{   
    
    private double global[];  
    private double omega;
    private double phi_p;
    private double phi_g;    

    public Swarm(Individual[] individuals,Function function, double omega, double phi_p,double phi_g) {
       
        super(individuals,function, 0, 0);    
        
        this.omega=omega;
        this.phi_p=phi_p;
        this.phi_g=phi_g;          
        
        global=function.ranDoubleVector();
        
        for (int i = 0; i < this.individuals.length; i++)   
            if(this.individuals[i].getFitness()<this.getGlobalFitness())
                global=(((Particle)this.individuals[i]).getP());           
        
    }

    public double[] getGlobal() {
        return global;
    }

    public void setGlobal(double[] global) {
        this.global = global;
    }
    
    public double getGlobalFitness(){             
        return function.calculate(global);        
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
            double v[]=particle.getSpeed();      
            double g[]=this.getGlobal();
            
            for (int d = 0; d < n; d++) {
                double r_p= ran.nextDouble();
                double r_g= ran.nextDouble();
                v[d]=omega*v[d]+phi_p*r_p*(p[d]-x[d])+phi_g*r_g*(g[d]-v[d]);   
            }

            
            particle.setSpeed(v);  
            
            double aux=this.getGlobalFitness();
            //System.out.println("globalfitness: "+aux);
            System.out.println("global:"+Arrays.toString(global)); 
            
            particle.move();  
            
            double aux2=this.getGlobalFitness();
            //System.out.println("globalfitness: "+aux2);
            System.out.println("global:"+Arrays.toString(global)); 
            
            double diff=aux2-aux;
            
            if(diff!=0){
                System.out.println("diff:"+diff);     
                System.exit(-1);
            }
            
            
            

            
            if(function.calculate(particle.getX())<function.calculate(particle.getP()))
                particle.setP(particle.getX());  
            
            System.out.println(Arrays.toString(global));            
            System.out.print(i+"\t");
            System.out.println(this.getGlobalFitness()+"\t");   
            
            delay(50);
            
            double fp_i=function.calculate(particle.getP());
            
            double fg=function.calculate(global); 
            
            if(fp_i<fg){                
                    this.setGlobal(particle.getP());
                    System.out.print(i+"\t");
                    System.out.printf("%f -- %f:%f ",fp_i,fg,this.getGlobalFitness());
                    System.out.println("mejoro");       
                    delay(5000);
            }  

            
        }
        
    }
    
    public void delay(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Swarm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
