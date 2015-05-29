import java.util.Scanner;

/**
 * 
 * @author sholland
 * acsl program 4
 * last modified 4-13-15
 */
public class ShAcsl4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dataInput[] = new String[5];
		int counter = 0;
		
		while(counter < 6) {
			dataInput[counter] = scan.nextLine();
			System.out.println("ABC");
			counter ++;
			//System.out.println(counter);
		}
		scan.close();
	}	
	
	
//	funky test class stuff that i might or might not use	
//	
//	String[] inputArray;
//	public ShAcsl4(String dataInput) {
//		dataInput = dataInput.substring(1,dataInput.length()-1);
//		inputArray = dataInput.split(" (?=\\()");
//	}
//	
//	public String run(String commandInput) {
//		String[] data = commandInput.split(" ");
//		
//		return "A B C";
//		
//	}
}