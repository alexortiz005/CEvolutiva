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
public class Styblinski extends Function {

    public Styblinski(double limit, int dimension) {
        super(limit, dimension);
    }

    @Override
    public double calculate(double[] x) {
        if(x.length!=this.dimension)
            throw new IllegalArgumentException("Dimension del argumento incompatible");
        double sum=0;
        
        for (int i = 0; i < x.length; i++) {
            sum+=x[i]*x[i]*x[i]*x[i]-16*x[i]*x[i]+5*x[i];
            
        }        
        
        return sum/2;
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
