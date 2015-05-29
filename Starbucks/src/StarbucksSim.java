

public class StarbucksSim {
	public static void main(String[] args) {
		StoreStore star = new StoreStore(100);

		Customer[] customers = new Customer[100];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}

		int rounds = 100;
		for (int j = 0; j < rounds; j++) {
			for (Customer c : customers) {
				c.placeOrder(star);
				System.out.println(c);
			}
			System.out.println(star);
		}

	}
}
