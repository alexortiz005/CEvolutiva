/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.HashMap;

/**
 *
 * @author root
 */
public class Beale extends Function {

    public Beale(double limit) {
        super(limit, 2);
    }

    @Override
    public double calculate(double[] arr) {
        
        if(arr.length!=this.dimension)
           throw new IllegalArgumentException("Dimension del argumento incompatible");
        
        double x=arr[0];
        double y=arr[1];
        double sum=0;
        
        sum+=(1.5-x+x*y)*(1.5-x+x*y)+(2.25-x+x*y*y)*(2.25-x+x*y*y)+(2.625-x+x*y*y*y)*(2.625-x+x*y*y*y);
        
        return sum;
        
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
