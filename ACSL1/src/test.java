/**
 * Recursion Assignment
 * @sholland 
 *
 * Remove the NotImplemented line from any methods you write
 * DO NOT change the method signatures
 * You MAY write helper classes
 */
public class test {
	/*
	 *
	 * Factorial (0pt)
	 * F(n ) = n * F(n-1)     (if n > 0)
	 * F(0) = 1
	 */
	static int factorial(int num) { //good 0 pts
		if(num<=0) return 1;
		return num * factorial(num-1);
	}
	
	/*
	 * Summation (1pt)
	 * S(n ) = n + S(n-1)     (if n > 0)
	 * S(0) = 0
	*/
	static int summation(int n) { //good 1 pt
		if(n<=0) return 0;
		return n + summation(n-1);	
	}
	
	/*
	 * Fibonacci (1pt)
	 * F(0) = 0
	 * F(1) = 1
	 * F(n ) = F(n-1) + F(n-2) (if n > 0)
	 */
	static int fibonacci(int n) { //good 1pt
		if (n<= 0) return 0;
                if (n==1) return 1;
                return (fibonacci(n-1) + fibonacci(n-2));
	}
	
	/*
	 * Sum of a number's digits (1pt)
	 * S(n ) = n					(if n < 10)
	 * S(n ) = S(n/10) + n mod 10   (if n>= 10)
	*/
	static int sumDigits(int n) { //good 1pt
		if (n<10 && n>= 0) return n;
		return (sumDigits(n/10) + n % 10);
        }	

	/*
	 * Product of a number's digits (1pt)
	 * S(n ) = n					(if n < 10)
	 * S(n ) = S(n/10) * n mod 10   (if n>= 10) 
	 */
	static int productDigits(int n) { //failed
		if(n>=10) return (n/10) * (n % 10);	
		return n;		
	}

	/*
	 * Product of two whole numbers (1pt)
	 * P(a,b) = a + P(a,b-1)        (if b > 0)
	 * P(a,0) = 0
	 */
	static int product(int a, int b) { //good 1pt
		if(a==0 ||  b==0) return 0;
		return (a + product(a,b-1));		
	}
	
	/*
	 * Sum over a range of numbers (1pt)
	 * S(a,b) = a				(if a = b)
	 * S(a,b) = b + S(a,b-1)
	 */
	static int sumRange(int a, int b) { //good 1pt
		if(a==b) return a;
		return b + sumRange(a,b-1);
	}

	/*
	 * Reverse a number's digits (2pt)
	 * R(n,v) = n + 10 * v				  (if n < 10)
	 * R(n,v) = R(n/10, 10*v + n mod 10))
	 * (v begins at 0)
	 */
	static int reverseDigits(int n) { //need to test
    	return reverseDigits(n, 0);
	}

	static int reverseDigits(int n, int v) {
		if(n < 10) return n;
		return reverseDigits(n/10, (10*v) + (n%10));
	}
	
	/*
	 * Euclid's Algorithm for GCD (2pt)
	 * GCD(x,y) = y                 (if y <= x & x mod y=0)
	 * GCD(x,y) = GCD(y,x mod y)
	 */
	static int gcd(int x, int y) { //good 2pts
		if(x==0 || y==0) return 0;
		if(y<=x && x%y==0) return y;
		return gcd(y,x%y);
	}
	
	/*
	 * Compound interest balance (2pt)
	 * B(p,r,t) = P                (if t = 0)
	 * B(p,r,t) = (1+r)*B(p,r,t-1)
	 */
	static double compound(double p, double r, int t) { //good 2pts
		if(t==0) return p;
		return (1+r)*(compound(p,r,t-1));
		
	}
	
	/*
	 * Newton's algorithm for square root (3pt)
	 * SR(n,p,e) = e				 (if | e^2 - n | < p)
	 * SR(n,p,e) = SR(n,p,(e+n/e)/2)
	 * (e begins at n)
	 * n is number, p is the error, e is estimate
	 */
	static double sqrtNewton(double n, double p) { //need to test
		return sqrtNewton(n, p, n);
	}
	
	static double sqrtNewton(double n, double p, double e) {
		if(Math.abs(Math.pow(e, 2) - n) < p) return n;
		double x = (e+n/e)/2;
		return sqrtNewton(n, p, x);
		}

	
	 /* Bisection method for square root (3pt)
	 * SR(n,p,h,l) = e				(if | e^2 - n | <= p)
	 * SR(n,p,h,l) = SR(n,p,e,l)    (if e^2 > n)
	 * SR(n,p,h,l) = SR(n,p,h,e)    
	 * (where e=(h+l)/2, h begins at n, and l begins at 0)
	 */
	 
	static double sqrtBisection(double n, double p) { //need to test
		return sqrtBisection(n, p, n, 0);
	}
	
	static double sqrtBisection(double n, double p, double h, double l) {
		double e = (h+1)/2;
		if(Math.abs(Math.pow(e, 2) - n) <=p) return e;
		if(Math.pow(e, 2) > n) return sqrtBisection(n, p, e, l);
		return sqrtBisection(n, p, h, e);
	}

	/*
	 * Combinations (2pt)
	 * C(n,k) = n			(if k = 1)
	 * C(n,k) = 0			(if k > n)
	 * C(n,k) = 1			(if k = n)
	 * C(n,k) = C(n-1,k) + C(n-1,k-1)
	 */
	static int combinations(int n, int k) { //need to test
		if(k==1) return n;
		else if(k > n) return 0;
		else if(k==n) return 1;
		return combinations(n-1, k) + combinations(n-1, k-1);
	}	
}