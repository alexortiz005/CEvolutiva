/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

import java.util.Random;

/**
 *
 * @author operador
 */
public abstract class BinaryOperator {
    
    public abstract double operate(double a, double b);   
    
    public static BinaryOperator randomBinaryOperator(){
        
        Random ran= new Random();
        
        if(ran.nextDouble()<0.5){
            return new Multiplicacion();
        }else{
            return new Suma();
        }
        
    }
        
}
