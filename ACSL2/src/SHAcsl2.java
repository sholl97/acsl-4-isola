import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* test data
 *(ADD (EXP -3 2) (SQR 5) (SUB 6 2) (MULT 6 7 -2 3) (DIV 15 5))
 * 1. SORT 3 5
 * 2. REVERSE 1 4
 * 3. COUNT
 * 4. REMOVE 3 4
 * 5. MAXIMUM
 */

/**
 * @author sholland
 * ACSL 2
 * last submission: 3-13-15
 */
public class SHAcsl2 {
	//declarations
	String[] lispParts;
	ArrayList<String> data = new ArrayList<String>();

	//take in data
	/***
	 * TAKE IN DATA
	 * @param dataInput: the first line of input that the user enters
	 */
	public SHAcsl2(String dataInput) {
		dataInput = dataInput.substring(1,dataInput.length()-1);
		lispParts = dataInput.split(" (?=\\()");
		data.addAll(Arrays.asList(lispParts));
	}

	/**
	 * RUN - run each function
	 * @param commandInput: the type of command entered by the user
	 * @return the requested output for each command
	 */
	public String run(String commandInput) {
		String[] commands = commandInput.split(" ");
		String countVar = null;

		/* */if(commands[0].equals("COUNT")) {
			countVar = count();
			return countVar;
		}
		else if(commands[0].equals("MAXIMUM")) {
			return maximum();
		}
		else if(commands[0].equals("REVERSE")) {
			return reverse(commands);
		}
		else if(commands[0].equals("SORT")) {
			return sort(commands);
		}
		else if(commands[0].equals("REMOVE")) {
			return remove(commands, countVar);
		}
		else {
			return null;
		}
	}

	/** 
	 * COUNT - DONE
	 * @return the number of operations
	 */
	private String count() {
		return "" + (data.size() - 1);
	}

	/**
	 * MAXIMUM - DONE
	 * @return the function with the most amount of numbers
	 */
	private String maximum() {
		return Collections.max(data, new Comparator<String>() {
			@Override

			public int compare(String o1, String o2) {
				return o1.split(" ").length - o2.split(" ").length;
			}
		});
	}

	/**
	 * REMOVE - DONE
	 * @param commands: string array with the command (remove) and the range of which to remove
	 * @param count: the size of the list, determined by the count function
	 * @return the updated list
	 */
	private String remove(String[] commands, String count) {
		//declarations
		ArrayList<String> removeList = new ArrayList<String>(data);
		int fromIndex = Integer.parseInt(commands[1]);
		int toIndex = Integer.parseInt(commands[2]);
		String output = "";

		//System.out.println(removeList.toString()); //debug

		//remove the specified data
		for (int i = 0; i < data.size() ; i++) {
			if(i >= fromIndex && i <= toIndex) {
				removeList.remove(fromIndex);
			}
		}

		//format the correct output
		for(String x : removeList) {
			output += x + " ";
		}

		//return the correct output
		return "(" + output.trim() + ")";
	}

	/** SORT - DONE (?)
	 * @param commands: string array with the command (sort) and the range of which to sort
	 * @return the sorted list
	 */
	private String sort(String[] commands) {
		//declarations
		ArrayList<String> sortList = new ArrayList<String>(data);
		int fromIndex = Integer.parseInt(commands[1]) - 1;
		int toIndex = Integer.parseInt(commands[2]) - 1;
		String output = "";

		//debug
		//System.out.println(removeList.toString());

		//create the sublist to be sorted
		for (int i = 0; i < data.size() ; i++) {
			if(i >= fromIndex && i <= toIndex) {
				sortList.add(data.get(i));
			}
		}

		//sort the sublist
		Collections.sort(sortList);
		//System.out.println(sortList.toString());

		for (int i = 0; i < data.size(); i++) {
			data.set(i, sortList.get(0));
			sortList.remove(0);
		}

		//format the correct output
		for(String x : data) {
			output += x + " ";
		}

		//return the correct output
		return "(" + output.trim() + ")";
	}
	/*

		//declarations
//		ArrayList<String>begSub = new ArrayList<String>();
//		ArrayList<String>midSub = new ArrayList<String>();
//		ArrayList<String>endSub = new ArrayList<String>();
		ArrayList<String>sortedList = new ArrayList<String>();

//sublist
		for (int i = 0; i < data.size(); i++) {
			if(i <= fromIndex && i >= toIndex) {
				sortedList.add(data.get(i));
				System.out.println(sortedList.toString());
			}
		}

		//sort
		Collections.sort(sortedList);	//sort
	//	System.out.println(sortedList); //debug

		//replace
		for (int i = 0; i < data.size(); i++) {
			if(i >= fromIndex && i <= toIndex) {
				data.set(i, sortedList.get(0));
				sortedList.remove(0);
			}
		}
		return data.toString().replaceAll("\\[", "").replaceAll("\\]","");

		//		midSub.addAll(fromIndex, data);
		//		endSub.addAll(toIndex, data);
		//		begSub.addAll(0, data);

		//subList.addAll(0, data.subList(fromIndex, toIndex));		//fill the sublist

		//Collections.sort(midSub);									//sort the sublist


		//		data.clear();
		//		data.addAll(begSub);
		//		data.addAll(midSub);
		//		data.addAll(endSub);

		//		System.out.println(data.toString());
		//data.add(fromIndex, subList.toString());					//fill the original list
	}*/
	/**
	 * REVERSE
	 * @param commands: string array with the command (reverse) and the range of which to reverse
	 * @return the reversed list
	 */
	private String reverse(String[] commands) {
		//declarations
		ArrayList<String> revSub = new ArrayList<String>();
		int fromIndex = Integer.parseInt(commands[1]) - 1;
		int toIndex = Integer.parseInt(commands[2]) - 1;
		String output = "";

		//fill the new list
		for (int i = 0; i < data.size(); i++) {
			if(i >= fromIndex && i <= toIndex) {
				revSub.add(data.get(i));
			}
		}

		//reverse the new list
		Collections.reverse(revSub);
		//System.out.println(revSub.toString()); //debug

		//replace old list with new list
		for (int i = 0; i < data.size(); i++) {
			if(i >= fromIndex && i <= toIndex) {
				data.set(i, revSub.get(0));
				revSub.remove(0);
			}
		}

		//format the correct list
		for(String x : revSub) {
			output += x + " ";
		}
		return "(" + output.trim() + ")";
	}
}