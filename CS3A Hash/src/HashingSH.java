import java.text.DecimalFormat;
import java.util.Scanner;

public class HashingSH {

	/***
	 * FACSL Hashing
	 * @author sholland
	 * last updated 11.24.14
	 * 
	 * TEST DATA:
	 * 3, h, f, e, d, c, b, a
	 * 10, a, z, c, p
	 * 
	 */
	public static void main(String[] args) {
		//DECLARATIONS
		Scanner scan = new Scanner(System.in);						//scanner
		
		DecimalFormat df1 = new DecimalFormat(".00");				//formatting for collision rate
		DecimalFormat df2 = new DecimalFormat("0%");				//formatting for max chain depth
		
		String data = scan.nextLine().toLowerCase();				//input from scanner
		String[] input = data.split(", ");							//splice and ignore case

		int size = Integer.parseInt(input[0]);						//size of the array
		int[] table = new int[size];								//the array

		//1. COLLISION COUNT
		int collisions = 0;

		for (int i = 1; i < input.length; i++) {					//for each letter
			char c = input[i].charAt(0);							//get the index
			int index = c - 'a';									//set the index
			table[index%size]++;									//put in the table
		}
		//System.out.println("check-in: " + Arrays.toString(table));

		for (int j = 0; j < table.length; j++) {					//for each number
			if(table[j]!=0) collisions += table[j]-1;				//if value is not 0, then add to collisions
		}
		System.out.println(collisions);

		//2. COLLISION RATE
		double collrate = 0;
		//System.out.println(collisions + ", " + (input.length-1));	//check-in
		collrate = (double)collisions/(double)(input.length-1);		//number of collisions / size of input

		System.out.println(df1.format(collrate));					//print in a specific format

		//3. TABLE MASK		
		for (int k = 0; k < table.length; k++) {
			if(table[k]==0) System.out.print("-");					//if it's 0, print "-"
			else System.out.print("x");								//if not, print "x"
		}
		System.out.print("\n");										//new line for print-out
		
		//4. MAX CHAIN DEPTH
		int maxchain = 0;

		for (int m = 0; m < table.length; m++) {					//look through every value
			if (table[m] > maxchain) maxchain = table[m]-1;			//if a value is greater than maxchain, set maxchain to that value
		}
		System.out.println(maxchain);

		//5. LOAD PERCENTAGE
		double load = 0;											//load
		int counter = 0;											//counter to count the values that are >0
		for (int n = 0; n < table.length; n++) {					//look through every value
			if(table[n]!=0) counter ++;								//
		}
		load = (double)counter/size;
		System.out.println(df2.format(load));						//print in a specific format
	}
}