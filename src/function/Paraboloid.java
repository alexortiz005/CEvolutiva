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
public class Paraboloid extends Function{

    public Paraboloid(int dim, double limit) {
        super(dim, 2);
    }

    @Override
    public double calculate(double[] x) {
        double sum=0;
        
        for (int i = 0; i < x.length; i++) {
            sum+=x[i]*x[i];            
        }
        
        return sum;
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
