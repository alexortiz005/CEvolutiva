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
public abstract class RealIndividual extends Individual {
    
    protected double x[];
    
    public RealIndividual(double x[]){
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
  
    
}
