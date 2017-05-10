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
public class Eggholder extends Function {

    public Eggholder(double limit) {
        super(limit, 2);
    }

    @Override
    public double calculate(double[] arr) {
        
        if(arr.length!=this.dimension)
            throw new IllegalArgumentException("Dimension del argumento incompatible");
        
        double x=arr[0];
        double y=arr[1];
        
        double t1=(y+47);
        
        double result=-t1*Math.sin(Math.sqrt(Math.abs((x/2)+t1)))-x*Math.sin(Math.abs(x-t1));
        
        return result;
        
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
