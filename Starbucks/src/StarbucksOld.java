/*
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StarbucksOld {

	/***
	 * population per square mile
	 * average number of people who visit per store
	 * city vs rural
	 * grand central vs. east village
	 * 
	 * WILLIAMSBURG, BROOKLYN
	 * population: 126,183
	 * size: 2.179 square miles
	 * density: 57,896 persons psm, 145 ppb
	 * 
	 * median household income: $35,499
	 * 
	 * TODO
	 * count how many people who go to starbucks
	 * start writing code
	 * think about what our algorithm will be
	 * go to starbucks and observe!
	 * 
	 *

	public static void main(String[] args) {

		Random gen = new Random();

		List<Integer> custperhour = new ArrayList(100);

		//		int numhours= 18;
		//		System.out.println(ages.size());
		//		System.out.println(ages.get(0)); //print out 0

		StoreStore franchise1 = new StoreStore(10000);
		//		StoreStore franchise2 = new StoreStore(10000);
		//		StoreStore franchise3 = new StoreStore(10000);
		//		StoreStore franchise4 = new StoreStore(10000);
		//		StoreStore franchise5 = new StoreStore(10000);
		Scanner scan = new Scanner(System.in);
		System.out.println("How many people are in the area?");
		double numPeople = scan.nextDouble();
		System.out.println("Over how many square miles?");
		double distance = scan.nextDouble();
		
		System.out.println(shopDist(numPeople, distance));
		 
	}

	public static double shopDist(double distance, double numPeople)
	{
		double numBlocks = distance/400;//number of square blocks per distance given
		double numPeopleBlock = numPeople/numBlocks;
		double storeDist1 = numPeopleBlock/.05;//per 5000 people
		double storeDist = 1/storeDist1;
		double numStores = numBlocks/(storeDist*storeDist);
		System.out.println("You should have "+numStores+" of stores in that sized area with that sized population.  Each store should be this many blocks apart:");
		return storeDist;
		
	}

}
class Product{}
class StoreStore {
	// all the orders in line at the store
	public List<Product> orderHistory = new LinkedList<Product>();
	// all the possible menu items
	public List<Product> menu = new LinkedList<Product>();
	// the amount of money the store has made
	public int bank;

	/*** StoreStore
	 * constructor for the store
	 * 
	 * @param bank - amounf of $ that starts in the bank
	 *

	public StoreStore(int bank) {

		int numhours = 18;
		int money = bank;

		int hour1money = 0;						//bank for 5am-7am
		int hour2money = 0;						//bank for 7am-9am
		int hour3money = 0;						//bank for 9am-11am
		int hour4money = 0;						//bank for 11am-1pm
		int hour5money = 0;						//bank for 1pm-3pm
		int hour6money = 0;						//bank for 3pm-5pm
		int hour7money = 0;						//bank for 5am-7am
		int hour8money = 0;						//bank for 5am-7am

		Random gen = new Random();

		List<Integer> hour1 = new ArrayList();	//from 5am-7am
		int temp1 = gen.nextInt(24)+200;		//range of 200-225 cust
		for (int i = 0; i < temp1; i++) {
			int custmoney = 0;
			custmoney = gen.nextInt(5)+2;
			hour1.add(i, custmoney);
			hour1money = hour1money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour1money + " between the hours of 5am-7am.");

		List<Integer> hour2 = new ArrayList();	//from 7am-9am
		int temp2 = gen.nextInt(24)+300;		//range of 300-325 cust
		for (int i = 0; i < temp2; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour2.add(i, custmoney);
			hour2money = hour2money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour2money + " between the hours of 7am-9am.");

		List<Integer> hour3 = new ArrayList();	//from 9am-11am
		int temp3 = gen.nextInt(24)+150;		//range of 150-175 cust
		for (int i = 0; i < temp3; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour3.add(i, custmoney);
			hour3money = hour3money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour3money + " between the hours of 9am-11am.");

		List<Integer> hour4 = new ArrayList();	//from 11am-1pm
		int temp4 = gen.nextInt(14)+100;		//range of 100-115 cust
		for (int i = 0; i < temp4; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour4.add(i, custmoney);
			hour4money = hour4money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour4money + " between the hours of 11am-1pm.");

		List<Integer> hour5 = new ArrayList();	//from 1pm-3pm
		int temp5 = gen.nextInt(14)+100;		//range of 100-115 cust
		for (int i = 0; i < temp5; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour5.add(i, custmoney);
			hour5money = hour5money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour5money + " between the hours of 1pm-3pm.");

		List<Integer> hour6 = new ArrayList();	//from 3pm-5pm
		int temp6 = gen.nextInt(24)+150;		//range of 150-175 cust
		for (int i = 0; i < temp4; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour6.add(i, custmoney);
			hour6money = hour6money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour6money + " between the hours of 3pm-5pm.");

		List<Integer> hour7 = new ArrayList();	//from 5pm-7pm
		int temp7 = gen.nextInt(14)+115;		//range of 115-130 cust
		for (int i = 0; i < temp4; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour7.add(i, custmoney);
			hour7money = hour7money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour7money + " between the hours of 5pm-7pm.");

		List<Integer> hour8 = new ArrayList();	//from 7pm-9pm
		int temp8 = gen.nextInt(24)+75;		//range of 75-100 cust
		for (int i = 0; i < temp4; i++) {
			int custmoney = gen.nextInt(5)+2;	
			hour8.add(i, custmoney);
			hour8money = hour4money+custmoney;
		}
		System.out.println("The coffee shop made $" + hour8money + " between the hours of 7pm-9pm.");

		int daytotal = hour1money + hour2money + hour3money + hour4money + hour5money + hour6money + hour7money + hour8money;
		money = money + daytotal;

		System.out.println("The coffee shop made $"+ daytotal +" on this day.");
		System.out.println("Total money in the bank: $" + money);
	}

	/**
	 * take the product and process the order
	 *
	public void processOrder(Product p) {

	}	

	public String toString() {
		return null;
	}

	//calculates number of stores based on people in a certain square mileage

}