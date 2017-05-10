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
public class Rosenbrock extends Function{
    
    protected double a;
    protected double b;

    public Rosenbrock(double limit, double a, double b) {
        super(limit, 2);
        this.a=a;
        this.b=b;
    }

    @Override
    public double calculate(double[] arr) {
        
        if(arr.length!=this.dimension)
            throw new IllegalArgumentException("Dimension del argumento incompatible");
        
        double x=arr[0];
        double y=arr[1];
        
        return (a-x)*(a-x)+b*(y-x*x)*(y-x*x);
        
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
