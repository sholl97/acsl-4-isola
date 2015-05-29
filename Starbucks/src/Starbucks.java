import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Starbucks {

	/***
	 * population per square mile
	 * average number of people who visit per store
	 * city vs rural
	 * grand central vs. east village
	 * 
	 * WILLIAMSBURG, BROOKLYN
	 * population: 126,183
	 * size: 2.25 square miles
	 * density: 57,896 persons per square mile, 145 persons per block
	 * 
	 * median household income: $35,499
	 * 
	 * LAST UPDATED 27 MAY 2014 900 AM
	 */

	public static void main(String[] args) {
		//declarations
		Random gen = new Random();
		Scanner scan = new Scanner(System.in);  // scans user input
		List<Integer> custperhour = new ArrayList(100);

		Store franchise1 = new Store(10000);            //create one store
		//      Store franchise2 = new Store(10000);
		//      Store franchise3 = new Store(10000);
		//      Store franchise4 = new Store(10000);
		//      Store franchise5 = new Store(10000);

		System.out.println("\nHow many people are in the area?");   // takes user input of people in area
		double numpeople = scan.nextDouble();

		System.out.println("How many square miles is your area?");  // takes in user input of square mileage
		double distance = scan.nextDouble();

		System.out.println(shopDist(numpeople, distance));          // prints out number of stores and distance apart. 

		System.out.println("Based on the number of customers who visit your store, you should have " + Math.round(calcStore(franchise1, numpeople)) + " stores."); // determines number of stores
	}


	/*** shopDist: determine the number of stores over a given area with a given population
	 * 
	 * @param distance the square mileage of the area in need of coffee shops
	 * @param numpeople the number of people in the area
	 * @return the distance between each coffee shop
	 */
	//calculates the number of stores based on population density. 
	public static java.lang.String shopDist(double distance, double numpeople)
	{
		double numblocks = distance/400;                    //number of square blocks per distance given
		double numpeopleblock = numpeople/numblocks;        // people รท number of blocks = people per blocks
		double storedist1 = numpeopleblock/.05;             //per 5000 people
		double storedist = Math.round(1/storedist1);
		double numstores = Math.round(numblocks/(storedist*storedist));
		String diststore = "Based on population and square miles, you should have " + Math.round(numstores) + " stores. Each store should be " + Math.round(storedist) + " blocks apart."; // // print out number of stores
		return diststore;

	}
	public static double calcStore(Store s, double population) {
		double stores = 0;
		stores = Math.round((population/10)/s.peopleday); //stores based on people per day 
		return stores;
	}
}

class Store {
//	/** all the orders in line at the store */
//	public List<Product> orderHistory = new LinkedList<Product>();
//	/** all the possible menu items */
//	public List<Product> menu = new LinkedList<Product>();
//	/** the amount of money the store has made */
	public int bank;
	double peopleday = 0;

	/*** Store
	 * constructor for the store
	 * 
	 * @param bank amount of $ that starts in the bank
	 */

	public Store(int bank) {
		//declarations
		Random gen = new Random();

		int money = bank;
		int[] hourmoney = new int[8];
		double[] popularity = new double[] {.2, .7, .4, .2, .5, .2, .2, .2};

		Arrays.fill(hourmoney, 0);

		//how much money the coffeeshop makes based on customer and average spending 
		System.out.println("There is $" + money + " in the bank at 900."); //money in back at 9:00
		for (int j = 0; j < hourmoney.length; j++) {
			List<Integer> hour = new ArrayList();
			double temp = (600+gen.nextInt(400)) *popularity[j];
			peopleday = Math.round(peopleday+temp);
			for (int i = 0; i < temp; i++) {
				int custmoney = 0;
				custmoney = gen.nextInt(5)+2;
				hour.add(i, custmoney);
				hourmoney[j] += custmoney;
			}
			System.out.println("The coffee shop made $" + hourmoney[j] + " between the hours of "+ (5 + j*2) + "00 - " + (7 + 2*j) +"00.");     
		}
		System.out.println(peopleday + " people visited on this day.");

		// total money made in a day 
		int daytotal = sumArray(hourmoney);
		money = money + daytotal;
		// How much money is in the bank to end the day and total profit for the day 
		System.out.println("There is $" + money + " in the bank at 2100.");
		System.out.println("The coffee shop made $" + daytotal + " on this day.");
	}

	static int sumArray(int[] i) {
		int sum=0;
		for (int j = 0; j < i.length; j++) {
			sum += i[j];
		}
		return sum;
	}
}