import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class StoreStore {
	/** all the orders in line at the store */
	public List<Product> orderHistory = new LinkedList<Product>();
	/** all the possible menu items */
	public List<Product> menu = new LinkedList<Product>();
	/** the amount of money the store has made */
	public int bank;
	double peopleday = 0;
	
	/*** StoreStore
	 * constructor for the store
	 * 
	 * @param bank amount of $ that starts in the bank
	 */

	public StoreStore(int bank) {
		//declarations
		Random gen = new Random();

		int money = bank;
		int[] hourmoney = new int[8];
		double[] popularity = new double[] {.2, .7, .4, .2, .5, .2, .2, .2};

		
		Arrays.fill(hourmoney, 0);

		System.out.println("There is $" + money + " in the bank at 900.");
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

		
		int daytotal = sumArray(hourmoney);
		money = money + daytotal;

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

	/**
	 * take the product and process the order
	 */
	//	public void processOrder(Product p) {
	//
	//	}	
	//
	//	public String toString() {
	//		return null;
	//	}
}