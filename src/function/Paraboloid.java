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

    public Paraboloid(double limit) {
        super(limit, 2);
    }

    @Override
    public double calculate(double[] x) {
        return x[0]*x[0]+x[1]*x[1];
    }

    @Override
    public HashMap<int[], Integer> ejemplos(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
