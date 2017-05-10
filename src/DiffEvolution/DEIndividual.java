/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffEvolution;

import function.Function;
import java.util.Arrays;
import population.Individual;

/**
 *
 * @author root
 */
public class DEIndividual extends Individual{
    
    public static Individual[] makeRandomIndividuals(int n, Function function){
        
        Individual[] output= new Individual[n];
        
        for (int i = 0; i < n; i++) {
            DEIndividual ind=new DEIndividual(function.ranDoubleVector());
            ind.calcularFitness(function);
            output[i]= ind;            
        }
        
        return output;
        
    }
    
    private double x[];
    
    public DEIndividual(double x[]){
        this.x=x;
    }  

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    } 
    
    public double getX(int i) {
        return x[i];
    }

    public void setX(int i,double a) {
        this.x[i] = a;
    }    
    
    public void calcularFitness(Function f){
        this.fitness=f.calculate(x);
    }

    @Override
    public Individual clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individual mutate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individual[] crossover(Individual mates[]) {
        
        DEIndividual a=(DEIndividual)mates[0];
        DEIndividual b=(DEIndividual)mates[1];
        DEIndividual c=(DEIndividual)mates[2];

        double y[]= new double[x.length];
        
        int R=random.nextInt(x.length);
        /*
        DEPopulation pop= (DEPopulation)this.getPopulation();
        
        double F= pop.getDifferencialWeight();
        
        El codigo de abajo hace lo mismo
        */
        
        double F= this.population.getMutationProbability();
        
        for (int i = 0; i < x.length; i++) {
            if(i==R || random.nextDouble()<this.population.getCrossoverProbability()){
                y[i]= a.x[i]+F*(b.x[i]-c.x[i]);           
            }else{
                y[i]= x[i];                
            }              
        }
        
        Individual result[]={new DEIndividual(y)};
        
        return result;
    
    }    

    @Override
    public String toString() {
        String s="["; //To change body of generated methods, choose Tools | Templates.
        
        for (int i = 0; i < x.length; i++) {
            s+=String.format("%.15f",x[i]); 
            if(i==x.length-1)
                continue;
            s+=";";
        }
        
        return s+"]";
    }
    
    
    
    
    
}
