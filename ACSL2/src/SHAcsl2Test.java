/*
 * (ADD (EXP -3 2) (SQR 5) (SUB 6 2) (MULT 6 7 -2 3) (DIV 15 5))
 */

import java.util.Scanner;

public class SHAcsl2Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SHAcsl2 data = new SHAcsl2(scan.nextLine());
		while (true) {
			System.out.println(data.run(scan.nextLine()));
		}
	}
}
