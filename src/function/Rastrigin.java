package function;

import java.util.HashMap;

public class Rastrigin extends Function{


	public Rastrigin(){
		super(5.12,0);
	}
        
        public Rastrigin(double limit, int dimension){
		super(limit, dimension);
	}

	public double calculate(double x[]){

		double n=x.length;
		double A=10.0;
		double sum=0.0;

		for(double xi:x)
			sum+=xi*xi-A*Math.cos(2*Math.PI*xi);

		return A*n+sum;

	}

	@Override
	public HashMap<int[], Integer> ejemplos(int n) {
		// TODO Auto-generated method stub
		return null;
	}


}
