/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Arrays;
import java.util.HashMap;
import population.Population;
import function.TestFunction;
import trees.Tree;
import trees.TreePopulation;

/**
 *
 * @author operador
 */
public class TreesTest implements Runnable{
    
    protected int iterations;
    protected int dimension;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public TreesTest(int iterations, int dimension) {
        this.iterations = iterations;
        this.dimension = dimension;
    }
    

    @Override
    public void run() {        
        
        TestFunction testFunction = new TestFunction(30,dimension);
    	
    	HashMap<int[], Integer> ejemplos = testFunction.ejemplos(300);  
    	
    	TreePopulation pop= new TreePopulation(Tree.makeRandomTrees(100, dimension,2),0.002, 0.1);
    	
    	pop.calcularFitnessParaTodos(ejemplos);
    	
    	pop.sortPopulation();
        
        System.out.print("i\t");
        System.out.print("best \t");            
        System.out.print("avg\t");            
        System.out.print("worst\n");
        
        int step=iterations/100;
        
        double previous=0;
        
        for (int i = 0; i < iterations; i++) {
            pop.evolve();
            pop.calcularFitnessParaTodos(ejemplos); 
            pop.sortPopulation();
            pop.trim(100);
            
            if(i%100==0){  
                pop.calcAvgFitness();
                
                double best=pop.get(0).getFitness();
                double avg=pop.getAvgFitness();
                double worst=pop.get(pop.size()-1).getFitness();
                
                if(previous==avg+best+worst){
                    pop.setCrossoverProbability(pop.getCrossoverProbability()*1.007);
                    pop.setMutationProbability(pop.getMutationProbability()*1.1);
                    //System.out.println("cp= "+pop.getCrossoverProbability());
                    //System.out.println("mp= "+pop.getMutationProbability());
                }
                
                System.out.print(i+"\t");
                System.out.print(best+"\t");            
                System.out.print(avg+"\t");            
                System.out.print(worst+"\n");
                
                previous=avg+best+worst;
                
                if(avg+best+worst<0.3)
                    break;
            }
            
            
            
            
        }
        
        System.out.println(pop.get(0));
        
        
 
        
    }
    
}
