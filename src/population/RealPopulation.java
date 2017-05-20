/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population;

import function.Function;

/**
 *
 * @author root
 */
public abstract class RealPopulation extends Population {
    
    protected Function function; 

    public RealPopulation(Individual[] individuals,Function function, double crossProb, double mutProb) {
        super(individuals, crossProb, mutProb);
        this.function=function;
    }    
    
    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    } 
    
    
    


    
}
