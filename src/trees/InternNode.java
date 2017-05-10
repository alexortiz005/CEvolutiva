/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Random;
import operator.BinaryOperator;

/**
 *
 * @author operador
 */
public class InternNode extends Node{
    
    protected BinaryOperator operator;    
    protected Node leftChild;
    protected Node rightChild;
    Random ran= new Random();


    public InternNode(int deepness, Tree myTree) {
        super(deepness, myTree);       
    }    

    public Tree getMyTree() {
        return myTree;
    }

    public void setMyTree(Tree myTree) {
        this.myTree = myTree;
    }

    public InternNode(int deepness, Node parent, Tree myTree) {
        super(deepness, parent, myTree);
    }  

    public BinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(BinaryOperator operator) {
        this.operator = operator;
    }
    
    public void setOperatorRandomly(){
        this.operator=BinaryOperator.randomBinaryOperator();
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    } 

    @Override
    public double result() {   
        return operator.operate(leftChild.result(), rightChild.result());
    }  
    
    @Override
    public void setRandomContent(){
        this.leftChild=makeRandomNode();
        this.rightChild=makeRandomNode();
    }
    
    
    public Node makeRandomNode(){      
        
        if(this.deepness < myTree.getDeepness()-1){
            if(ran.nextDouble()<0.1){
                return makeRandomLeaf();                 
            }else{
                return makeRandomInternNode();         
            }            
        }else{
            return makeRandomLeaf();            
        }        

    }
    
    public Leaf makeRandomLeaf(){
        Leaf leaf= new Leaf(deepness+1, myTree);        
        leaf.setRandomContent();
        return leaf;
    }
    
    public InternNode makeRandomInternNode(){
        InternNode internNode = new InternNode(deepness+1, myTree);        
        internNode.setOperatorRandomly();
        internNode.setRandomContent();
        return internNode;
    }
    
    @Override
    public String toString(){     
        
        String left=leftChild.toString();
        String op=operator.toString();
        String right= rightChild.toString();
        
        //return "("+left+"{"+id+"}"+op+right+")";        
        return "("+left+op+right+")";
    }

	@Override
	public void toQueue() {
		
		this.getMyTree().addToQueue(this.getLeftChild());
		this.getMyTree().addToQueue(this.getRightChild());
		this.getLeftChild().toQueue();
		this.getRightChild().toQueue();		
				
	}

	@Override
	public Node get(int i) {
		
		if (this.id == i)
			return this;
		
		Node leftResult= this.leftChild.get(i);
		Node rightResult= this.rightChild.get(i);
		
		if(leftResult!= null)
			return leftResult;
		if(rightResult != null)
			return rightResult;
		
		return null;
	}

    @Override
    public void set(int i, Node n) {
        
        if(this.leftChild.getId()==i){           
            this.leftChild=n;
            return;           
        }

        if(this.rightChild.getId()==i){
            this.rightChild=n;
            return;            
        }
        this.leftChild.set(i, n);
        this.rightChild.set(i, n);
    }

    @Override
    public Node clone(Tree newTree) {
        InternNode clon= new InternNode(this.deepness,newTree);
        clon.setOperator(this.getOperator());
        clon.setLeftChild(leftChild.clone(newTree));
        clon.setRightChild(rightChild.clone(newTree));
        return clon;
    }    
    
    
}
