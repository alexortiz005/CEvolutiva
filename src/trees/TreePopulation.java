package trees;

import java.util.HashMap;
import java.util.Iterator;


import population.Individual;
import population.Population;

public class TreePopulation extends Population {    

    public TreePopulation(Individual[] individuals, double CrossProb, double mutProb) {
        super(individuals, CrossProb, mutProb);
    }
    
    @Override
    public void setCrossoverProbability(double crossoverProbability) {
        if(crossoverProbability>0.01)
            crossoverProbability=0.01;
        this.crossoverProbability = crossoverProbability;
    }



    public void calcularFitnessParaTodos(HashMap<int[], Integer> ejemplos){	
            for (int i = 0; i < individuals.length; i++) {
                    Tree tree=(Tree)individuals[i];
                    tree.calcularFitness(ejemplos);
                    individuals[i]=tree;			
            }	
    }

    @Override
    public void evolve() {
        
        for (int i = 0; i < this.individuals.length; i++) {
            for (int j = i+1; j < this.individuals.length; j++) {
                
                Individual mates[]={individuals[j]};
                
                Individual[] result= individuals[i].randomCrossover(mates);                
                
                if (result!=null){
                    
                    Individual result0=result[0].randomMutate();
                    if(result0!=null)
                        result[0]=result0;

                    Individual result1=result[1].randomMutate();
                    if(result1!=null)
                        result[1]=result1;
                    
                    this.add(result);  
                    
                }
                              
            }    
        }
               
    }
	
	
	
	

}
