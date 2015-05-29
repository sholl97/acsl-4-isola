import java.text.DecimalFormat;

public class Pclassy {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##");
		double doub = nCr(100, 21);
		df.format(doub);
		System.out.println(doub);
		

	}

	public static double nCr(double n, double r){
		double num = factorial(n) / factorial(n-r) * factorial(r);
		return num;
		 
	}


	private static double factorial(double n) {
		double fact = 1; // this  will be the result
		for (double i = 1; i <= n; i++) fact *= i;
		return fact;
	}
 }

