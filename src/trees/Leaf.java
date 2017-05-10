/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Random;

/**
 *
 * @author operador
 */
public class Leaf extends Node {
    
    protected double content;   
    protected boolean isConstant;
    Random ran= new Random();

    public Leaf(int deepness, Tree myTree) {
        super(deepness, myTree);
    }

    public Leaf(int content, int deepness, Node parent, Tree myTree) {
        super(deepness, parent, myTree);
        this.content = content;
    }

    public void setContent(double content) {
        this.content = content;
    }
    
    @Override
    public void setRandomContent(){
        
        this.setIsConstantRandomly();
    	
        if(isConstant){
            this.content=ran.nextInt(41)-20;
        }else{
            this.content=ran.nextInt(myTree.getDimension());            
        }
        
    }

    public boolean isConstant() {
        return isConstant;
    }

    public void setIsConstantRandomly() {
        if(ran.nextDouble()<0.5){
            this.isConstant=true;
        }else{
            this.isConstant=false;            
        }
    }   

    public void setIsConstant(boolean isConstant) {
        this.isConstant = isConstant;
    }  
    
    @Override
    public String toString(){
        if(isConstant){
            //return "{"+id+"}"+""+this.content;
        	return ""+this.content;
        }else{
            //return "{"+id+"}"+"x_"+this.content;
        	return "x_"+(int)this.content;
        }
    }

    @Override
    public double result() {
        if(!isConstant){
            return myTree.x((int)content);
        }else{
            return this.content;
        }
    }
    

    @Override
    public Node get(int i) {
            if (this.id == i)
                    return this;
            return null;
    }

    @Override
    public void set(int i, Node n) {
       
    }
    
    @Override
    public void toQueue() {		

    }

    @Override
    public Node clone(Tree newTree) {
        Leaf newLeaf = new Leaf(this.deepness, newTree);
        newLeaf.setIsConstant(this.isConstant);
        newLeaf.setContent(this.content);
        return newLeaf;
    }

    
}
