package function;

import java.util.HashMap;

public class TestFunction extends Function{

	public TestFunction(double limit,int dimension) {
		super(limit,dimension);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(double[] x) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int calculate(int[] x){
		return x[0]*x[0]*x[0]+17*x[0]*x[1]-15;
	}

	@Override
	public HashMap<int[], Integer> ejemplos(int n) {
		HashMap<int[], Integer> ejemplos = new HashMap<int[], Integer>();
		for (int i = 0; i < n; i++) {
			int x[]=ranIntVector();
			ejemplos.put(x, this.calculate(x));			
		}
		return ejemplos;
	}

}
