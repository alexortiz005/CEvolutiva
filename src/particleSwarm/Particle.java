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
            double p[]= new double[x.length];
            System.arraycopy( x, 0, p, 0, x.length );
            Particle part=new Particle(x,p);
            part.calcularFitness(function);
            part.setRandomSpeed(function);
            output[i]= part;            
        }
        
        return output;
        
    }
    
    public static Individual makeRandomParticle(Function function){
        
        
        double x[]=function.ranDoubleVector();
        double p[]= new double[x.length];
        System.arraycopy( x, 0, p, 0, x.length );
        Particle part=new Particle(x,p);
        part.calcularFitness(function);
        part.setRandomSpeed(function);
        
        return part;           
       
        
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
    
    public void move(){    
        
        double[] aux_global=this.getSwarm().getGlobal();       
        double[] init=new double[aux_global.length];
        
        System.arraycopy( aux_global, 0, init, 0, aux_global.length );
        //System.out.println("firstinit:"+Arrays.toString(init));
        for (int i = 0; i < v.length; i++) {            
            x[i]+=v[i]; 
            //double[] global=this.getSwarm().getGlobal();
            //System.out.println("global:"+Arrays.toString(global)+"V_i:"+v[i]);
        }
        
        this.getSwarm().setGlobal(init);
        
        //System.out.println("lastinit:"+Arrays.toString(init));
        
         
        
    }

    public double[] getP() {
        return p;
    }

    public void setP(double[] p) {
        this.p = p;
    }
    
    public Swarm getSwarm(){
        return (Swarm)this.population;
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
