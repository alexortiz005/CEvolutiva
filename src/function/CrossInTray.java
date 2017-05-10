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
public class CrossInTray extends Function {

    public CrossInTray(double limit) {
        super(limit, 2);
    }

    @Override
    public double calculate(double[] arr) {
        
        if(arr.length!=this.dimension)
            throw new IllegalArgumentException("Dimension del argumento incompatible");
        
        double x=arr[0];
        double y=arr[1];
        
        double result=Math.sin(x)*Math.sin(y)*Math.exp(Math.abs(100-(Math.sqrt(x*x+y*y)/Math.PI)));
        result=-0.0001*Math.pow(Math.abs(result)+1, 0.1);
        
        return result;
        
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
