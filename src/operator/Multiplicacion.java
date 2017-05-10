/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

/**
 *
 * @author operador
 */
public class Multiplicacion extends BinaryOperator {    

    @Override
    public double operate(double a, double b) {
        return a*b;
    }
    
    @Override
    public String toString(){
        return " * ";
    }
    
    
}
