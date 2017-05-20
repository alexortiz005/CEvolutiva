package function;

import java.util.HashMap;
import java.util.Random;

public abstract class Function{

	protected double limit;
        protected int dimension;
        
	Random ran= new Random();

	public Function(double limit, int dimension){
		this.limit=limit;
                this.dimension=dimension;
	}

	public abstract double calculate(double[] x);

	public double getLimit(){

		return this.limit;

	}

        public int getDimension() {
            return dimension;
        }
        
        
	
	public abstract HashMap<int[], Integer> ejemplos(int n);
	
	public int[] ranIntVector(){
            
                int dim=this.dimension;
		
		int[] result = new int[dim];		
		for (int i = 0; i < dim; i++) {
			result[i]=(int) (ran.nextInt(2*(int)this.limit)-this.limit);			
		}		
		return result;	
		
	}
        
        public double[] ranDoubleVector(){
            
                int dim=this.dimension;
		
		double[] result = new double[dim];		
		for (int i = 0; i < dim; i++) {
			result[i]=(int) (ran.nextInt(2*(int)this.limit)-this.limit);
                        result[i]= ran.nextDouble()*2*this.limit-this.limit;
		}		
		return result;	
		
	}

}
