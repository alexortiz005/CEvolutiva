package population;

import java.util.Random;

public abstract class Individual implements Cloneable,Comparable<Individual> {
	
    protected double fitness;
    protected Population population;
    
    protected static Random random= new Random();

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }       
        

    public double getFitness() {
            return fitness;
    }

    public void setFitness(double fitness) {
            this.fitness = fitness;
    }

    @Override
    public int compareTo(Individual o) {

            if(this.getFitness()>o.getFitness())
                    return 1;

            if(this.getFitness()<o.getFitness())
                    return -1;

            return 0;

    }    
    
    public abstract Individual mutate();
    
    public Individual randomMutate(){
        if(random.nextDouble()>this.getPopulation().getMutationProbability())
            return null;  
        return this.mutate();
    }
    
    public abstract Individual[] crossover(Individual mates[]);    
    
    public Individual[] randomCrossover(Individual mates[]){
        
        if(random.nextDouble()>this.getPopulation().getCrossoverProbability())
            return null; 
        
        return crossover(mates);
    }

	

}
