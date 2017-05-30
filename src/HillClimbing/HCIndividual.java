/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillClimbing;

import function.Function;
import java.util.Arrays;
import jdk.nashorn.internal.objects.Global;
import population.Individual;
import population.RealIndividual;

/**
 *
 * @author root
 */
public class HCIndividual extends RealIndividual{

    static Individual[] makeRandomIndividuals(int n, Function f) {
        
        Individual[] output= new Individual[n];
        
        for (int i = 0; i < n; i++) {
            HCIndividual ind=new HCIndividual(f.ranDoubleVector());
            ind.calcularFitness(f);
            output[i]= ind;            
        }
        
        return output;
    }

    public HCIndividual(double[] x) {
        super(x);
    }
    
    public void evolve(){
        
        Function f= ((HCPopulation)this.getPopulation()).getFunction();
        
        double currentPoint[]=this.getX();
        
        double stepSize[]= new double[currentPoint.length];Arrays.fill(stepSize, random.nextGaussian()+1);
        
        double acc=random.nextGaussian()+1.2;
        
        double candidate[]= new double[5];
        
        candidate[0]=-acc;
        candidate[1]=-1/acc;
        candidate[2]=0;
        candidate[3]=1/acc;
        candidate[4]=acc;
        
        double before= f.calculate(this.getX());
        
        for (int i = 0; i < currentPoint.length; i++) {
            
            int best=1;
            double bestScore=Global.Infinity;
            
            for (int j = 0; j < 4; j++) {
                
                currentPoint[i] = currentPoint[i] + stepSize[i] * candidate[j];
                double temp=f.calculate(currentPoint);
                currentPoint[i] = currentPoint[i] - stepSize[i] * candidate[j];
                if(temp<bestScore){
                    bestScore=temp;
                    best=j;
                } 
            }
            
            if(candidate[best]==0){
                stepSize[i] = stepSize[i] / acc;                   
            }else{
                currentPoint[i] = currentPoint[i] + stepSize[i] * candidate[best];
                stepSize[i] = stepSize[i] * candidate[best]; // accelerate
            }            
        }
        
        if(f.calculate(currentPoint)<before)
            this.setX(currentPoint);       
        
    }

    @Override
    public Individual[] crossover(Individual[] mates) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Individual mutate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
