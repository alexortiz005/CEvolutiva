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
public abstract class Node {   
    
    protected int deepness; 
    protected Node parent;
    protected Tree myTree;
    protected int id;

    public Node(int deepness, Tree myTree) {
        this.deepness = deepness;
        this.myTree = myTree;
    }

    public Node(int deepness, Node parent, Tree myTree) {
        this.deepness = deepness;
        this.parent = parent;
        this.myTree = myTree;
    }       
    
    public Tree getMyTree() {
            return myTree;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeepness() {
        return deepness;
    }

    public void setDeepness(int deepness) {
        this.deepness = deepness;
    }    

    public Node getParent() {
        return parent;
    }

    public void setParent(Node Parent) {
        this.parent = Parent;
    }

    public abstract double result();  
    
    public boolean equals(Node other){
    	if(this.getMyTree().equals(other.getMyTree()) && this.getId()==other.getId())
    		return true;
    	return false;
    	
    }
    
    public abstract void toQueue();
    
    public abstract Node get(int i);  
    
    public abstract void set(int i,Node n);    

    public abstract Node clone(Tree newTree);    
    
    public abstract void setRandomContent();

    
}
