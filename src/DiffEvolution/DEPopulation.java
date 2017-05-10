/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffEvolution;

import function.Function;
import java.util.Arrays;
import population.Individual;
import population.Population;

/**
 *
 * @author root
 */
public class DEPopulation extends Population{
    
    private double F;
    private Function function; 

    public DEPopulation(Individual[] individuals,Function function, double crossProb, double mutProb) {        
        
        super(individuals, crossProb, mutProb);
        
        if(individuals.length<4)        
            throw new IllegalArgumentException("Debe haber al menos 4 individuos en la poblacion inicial");
        
        this.F=mutProb;
        this.function=function;
    }
    
    public double getDifferencialWeight(){
        return F;        
    }
    
    public void setDifferencialWeight(double F){
        this.F=F;
        
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }    

    @Override
    public void evolve() {
        
        int size=individuals.length;
        
        for (int i = 0; i <size ; i++) {            
            
            Individual individual= get(i);
            
            int i_a=ran.nextInt(size);
            int i_b=ran.nextInt(size);
            int i_c=ran.nextInt(size);
            
            while(i_a==i)
                i_a=ran.nextInt(size);  
            
            while(i_b==i || i_b==i_a)
                i_b=ran.nextInt(size);  
            
            while(i_c==i || i_c==i_a || i_c==i_b)
                i_c=ran.nextInt(size);                 

            Individual mates[]={ get(i_a),get(i_b),get(i_c) };
            
            Individual aux[]=individual.crossover(mates);
            
            DEIndividual son=(DEIndividual)aux[0];
            
            son.calcularFitness(function);
            
            if(son.getFitness()<individual.getFitness())
                this.set(i, son);
            
            son.setPopulation(this);
            
        }
        
    }      
    
    
}
