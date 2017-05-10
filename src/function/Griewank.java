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
public class Griewank extends Function{

    public Griewank(double limit, int dimension) {
        super(limit, dimension);
    }

    @Override
    public double calculate(double[] x) {
        
        if(x.length!=this.dimension)
            throw new IllegalArgumentException("Dimension del argumento incompatible");
        
        double sum=0;
        
        for (int i = 0; i < x.length; i++) {
            sum+=x[i]*x[i];            
        }
        
        sum/=4000;
        
        double mul=1;
        
        for (int i = 0; i < x.length; i++) {
            mul*=Math.cos(x[i]/Math.sqrt(i+1));            
        }
        
        return sum-mul+1;
        
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
