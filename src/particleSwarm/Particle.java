/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package particleSwarm;

import function.Function;
import java.util.Arrays;
import population.Individual;
import population.RealIndividual;

/**
 *
 * @author root
 */
public class Particle extends RealIndividual {
    
    protected double v[];
    protected double p[]; 
    
    public Particle(double[] x,double[] p) {        
        super(x);
        this.p=p;              
    }       
    
    public static Individual[] makeRandomParticles(int n, Function function){
        
        Individual[] output= new Individual[n];
        
        for (int i = 0; i < n; i++) {
            double x[]=function.ranDoubleVector();
            Particle part=new Particle(x,x);
            part.calcularFitness(function);
            part.setRandomSpeed(function);
            output[i]= part;            
        }
        
        return output;
        
    }

    public double[] getSpeed() {
        return v;
    }

    public void setSpeed(double[] v) {
        this.v = v;
    }
    
    public void setRandomSpeed(Function f){
        
        this.v= new double[x.length];
        
        double lim=2*f.getLimit();        
        
        for (int i = 0; i < x.length; i++) {
            v[i]=random.nextDouble()*2*lim-lim;            
        }        
    }

    public double[] getP() {
        return p;
    }

    public void setP(double[] p) {
        this.p = p;
    }


    @Override
    public Individual mutate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individual[] crossover(Individual[] mates) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "[x:"+Arrays.toString(this.x)+",p:"+Arrays.toString(this.p)+"v:"+Arrays.toString(this.v)+"]"; 
    }
    
    @Override
    public void calcularFitness(Function f){
        this.fitness=f.calculate(p);
    }
    
    
    
    


    
}
