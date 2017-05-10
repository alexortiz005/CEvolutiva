/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import operator.BinaryOperator;
import population.Individual;

/**
 *
 * @author operador
 */
public class Tree extends Individual {
    
    protected int x[];
    protected int dimension;
    protected InternNode root; 
    protected int deepness;
    protected int size;   
    protected Queue<Node> queue = new LinkedList<Node>();
    protected Stack<Node> stack= new Stack<>();     
    
    
    static Random random= new Random();

    public Tree(int[] x, int deepness, boolean random) {
        this.x = x;
        this.dimension=x.length;
        this.deepness=deepness;     
        if(random){            
            this.root= new InternNode(0, this);
            root.setOperatorRandomly();
            root.setRandomContent();       
        }else{
            
        }
       
    } 
    
    public void addToQueue(Node n){
    	this.queue.add(n);
    }
    
    public Node pollQueue(){
    	return queue.poll();
    }
    
    public int getSize() {
            return size;
    }

    public void setSize(int size) {
            this.size = size;
    }

    public int sizePlusPlus(){
            return this.size++;
    }
	
    
    public Tree(int dim, int deepness) {
        this.x = new int[dim];
        this.dimension=dim;
        this.deepness=deepness;
        this.root= new InternNode(0, this);
        root.setOperatorRandomly();
        root.setRandomContent();
        this.enumerate();
       
    }  

    public int x(int i){
        return x[i];        
    }   


    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public InternNode getRoot() {
        return root;
    }

    public void setRoot(InternNode root) {
        this.root = root;
    }

    public int getDeepness() {
        return deepness;
    }

    public void setDeepness(int deepness) {
        this.deepness = deepness;
    }
    
    @Override
    public String toString() {
        String s="";
        for (int i = 0; i < x.length; i++) {
            s+=", x_"+i+" = "+x[i];
        }
        return root.toString()+"\n"+s;        
    }
    
    public double result(){
        return root.result();
    }
    
    public double calculate(int x[]){
    	    		
        this.x=x;	
        return this.result();
    		
    }    
    
    public void calcularFitness(HashMap<int[], Integer> ejemplos){
    	
    	double sum=0;
    	
    	for (int[] name: ejemplos.keySet()){
    		
            double result=this.calculate(name);            
            int valor = ejemplos.get(name);  
            
            sum+= Math.abs(result-valor);            

    	}
    	
    	sum/=ejemplos.size();
    	this.setFitness(sum);
    }
    
    public static Tree[] makeRandomTrees(int n,int dimension, int deepness){
    	
    	Tree trees[]= new Tree[n];
    	
    	for (int i = 0; i < n; i++) {
    		trees[i]= new Tree(dimension, deepness);			
	}
    	
    	return trees;
    }
    
    public void enumerate(){
        
        this.setSize(0);
    	
    	this.addToQueue(this.root);
    	
    	this.root.toQueue();
    	
    	while(!this.queue.isEmpty()){
    		queue.poll().setId(sizePlusPlus());
    	}
    }
    
    public Node getNode(int i){
    	if(i>=0 && i< this.size)
    		return root.get(i);
    	return null;
    }
    
    public Node getRandomNode(){        
        return this.getNode(random.nextInt(this.size));        
    }
    
    public void setNode(int i, Node n){
        if(i>=0 && i< this.size)
            root.set(i, n);         
    }
    
    public Tree clone(){
        
        Tree result= new Tree(this.x,this.deepness,false);
        result.setRoot((InternNode)this.root.clone(result));
        result.setPopulation(population);        
        result.enumerate();
        
        return result;        
        
    }    
    
    @Override
    public Individual randomMutate(){
        if(random.nextDouble()>this.getPopulation().getMutationProbability())
            return null;  
        if(random.nextDouble()<0.5)
            return new Tree(dimension, deepness);	
        return this.mutate();
    }

    @Override
    public Individual mutate(){  
        
        Tree result = this.clone();
        result.getRandomNode().setRandomContent();        
        return result;
        
    }
    
    
    @Override
    public Individual[] crossover(Individual mates[]){    
        
        Individual couple=mates[0];
        
        Tree coupleTree= (Tree) couple;
        
        Tree a= (Tree) this.clone();
        Tree b= (Tree) coupleTree.clone();
        
        if(a.getDimension()!=b.getDimension())
            try {
                throw new Exception("trees dimention are not compatible");
        } catch (Exception ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        Node nodeA= a.getRandomNode();
        Node nodeB= b.getRandomNode();
        
        int idA= nodeA.getId();
        int idB= nodeB.getId();
        
        a.setNode(idA, nodeB);
        b.setNode(idB, nodeA);    
           
        a.enumerate();
        b.enumerate();
        
        Tree result[] = {a,b};
        
        return result;
        
    }  
    
    @Override
    public Individual[] randomCrossover(Individual mates[]){        
        double alpha= this.population.getAvgFitness()/this.getFitness();
        //System.out.println("alpha is: "+alpha);
        if(random.nextDouble()>this.getPopulation().getCrossoverProbability())
            return null;    
        return crossover(mates);
    }
    
    

    
}
