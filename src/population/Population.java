package population;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Population {
	
	protected Individual[] individuals;
	protected double avgFitness;	
        protected double mutationProbability;
        protected double crossoverProbability;
        protected Random ran= new Random();

        public Population(Individual[] individuals, double crossProb, double mutProb) {
            
            this.mutationProbability=mutProb;
            this.crossoverProbability=crossProb;            
            
            for (int i = 0; i < individuals.length; i++) {
                individuals[i].setPopulation(this);
            }
            
            this.individuals = individuals;
	}
        
        public double getMutationProbability() {
            return mutationProbability;
        }

        public void setMutationProbability(double mutationPropability) {
            this.mutationProbability = mutationPropability;
        }

        public double getCrossoverProbability() {
            return crossoverProbability;
        }

        public void setCrossoverProbability(double crossoverProbability) {            
            this.crossoverProbability = crossoverProbability;
        }
        
	public double getAvgFitness() {
		return avgFitness;
	}

	public void setAvgFitness(double avgFitness) {
		this.avgFitness = avgFitness;
	}

	
	public void sortPopulation(){
		Arrays.sort(this.individuals);
	}
	
	public void trim(int n){
		Individual[] result= new Individual[n];
		for (int i = 0; i < n; i++) {
			result[i]=this.individuals[i];
		}
		this.individuals=result;		
	}
	
	public void calcAvgFitness(){
		double sum=0;
		for (int i = 0; i < individuals.length; i++) {
			sum+=individuals[i].getFitness();			
		}
		sum/=individuals.length;
		this.setAvgFitness(sum);
	}
        
        public double getMedianFitness(){
            if(individuals.length%2==0){
                return get((size()/2)-1).getFitness()+get(size()/2).getFitness();          
            }else{
                return get(size()/2).getFitness();                
            }
        }
        
        public double bestFitness(){
            return get(0).fitness;           
        }
        
        public double worstFitness(){
            return get(size()-1).fitness;           
        }
        
        public void set(int i, Individual newIndividual){
		if(i>=0 && i<individuals.length){
			individuals[i]=newIndividual;
		}
	}
        
	
	public Individual get(int i){
		if(i>=0 && i<individuals.length){
			return individuals[i];
		}
		return null;
	}
        
        public Individual getRandomIndividual(){
            return get(ran.nextInt(size()));
        }
        
        public Individual best(){
            return get(0);
        }
        
        public Individual worst(){
            return get(size()-1);
        }       
        
	
	public int size(){
		return individuals.length;
	}
        
        public void add(Individual newIndividuals[]){
            
            Individual result[]= new Individual[newIndividuals.length+individuals.length];
            
            int j=0;
            
            for (int i = 0; i < individuals.length; i++) {
                result[j]=individuals[i]; 
                j++;      
            }
            
            for (int i = 0; i < newIndividuals.length; i++) {
                newIndividuals[i].setPopulation(this);
                result[j]=newIndividuals[i]; 
                j++;      
            }
            
            this.individuals=result;
        }
        
        public abstract void evolve();        

	
	

}
