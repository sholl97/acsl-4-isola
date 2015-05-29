import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * CS3A File IO Assignment (last updated 5/26/2015)
 * @author sholland
 */
public class ShFileIo {
	public static void main(String[] args) {
		try {
			//declarations
			File data = new File("/Users/student/cs3a/all_students_jan_new.csv");
			Scanner file = new Scanner(data);
			ArrayList<Student> student_list = new ArrayList<Student>();
			Student person;

			while(file.hasNextLine()) {
				String line = file.nextLine();	//read the file
				//System.out.println(line);		//print the CSV

				//fill the database
				String[] record = line.split(",");
				person = new Student(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10]);
				student_list.add(person);
			}

			//print the menu
			menu(student_list);

			//			BufferedReader bw = new BufferedReader(data);
			//			FileWriter fw = new FileWriter(file);
			//
			//
			//			bw.close();
			//			fw.close();


			file.close();

		//file not found
		} catch (FileNotFoundException e) {
			System.out.println("file not found...dumbass");
		}
	}

	/**
	 * print the DSIS menu
	 * @param list database of students
	 */
	public static void menu(ArrayList<Student> list) {
		//declarations
		Scanner scan = new Scanner(System.in);
		int selection = 0;
		char end = ' ';
		ArrayList<String> menu = new ArrayList<String>();

		//build the menu
		System.out.println("Welcome to the Dalton Student Information System! Please select a query using the numbers below.");
		menu.add("(0) List a student by only last name with associated data");
		menu.add("(1) List all twins");
		menu.add("(2) List students born in a certain month");
		menu.add("(3) List students in a certain house");
		menu.add("(4) List students sorted by last name");
		menu.add("(5) Compare students by gender");
		menu.add("(6) Compare the number of students in grades 4 and 10");
		menu.add("(7) List students born in 2001");
		menu.add("(8) List top 10 first names and their frequency");
		menu.add("(9) List students by grade");

		while(true) {
			//print the menu
			for (int i = 0; i < menu.size(); i++) {
				System.out.println(menu.get(i));
			}

			//run the functions
			selection = scan.nextInt();
			/* */if(selection==0) printDatabase(list);	//done
			else if(selection==1) twin(list);			//done
			else if(selection==2) birthMonth(list);		//done
			else if(selection==3) house(list);			//done
			else if(selection==4) sortLast(list); 		//done
			else if(selection==5) genderCount(list);	//done
			else if(selection==6) compareGrade(list);	//done
			else if(selection==7) born2001(list);		//done
			else if(selection==8) firstFrequency(list);	//done
			else if(selection==9) gradeLists(list);		//done
			else System.out.println("Sorry, DSIS does not recognize that query. Please try again.");

			//when function is complete
			//System.out.println("DONE");
			System.out.println("\nWould you like to run another query? (Y/N)");

			end = scan.next().charAt(0);
			if(end=='N'||end=='n') {
				System.out.println("Adios");
				break;
			}
		}
	}

	/**
	 * print the database of students and house advisors
	 * @param list the database of students
	 */
	public static void printDatabase(ArrayList<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getLn() + ", " + list.get(i).getFn() + " (" + list.get(i).getAdv() + ")");
		}
	}

	/**
	 * print a list of the pairs of twins
	 * @param list the database of students	 */
	public static void twin(ArrayList<Student> list) {
		//declarations
		ArrayList<Student> temp1 = new ArrayList<Student>(list);
		int size = temp1.size();
		
		//build the new list
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(temp1.get(i).getLn().equals(temp1.get(j).getLn()) &&		//same last name
						temp1.get(i).getBd().equals(temp1.get(j).getBd()) &&	//same birth day
						temp1.get(i).getBm().equals(temp1.get(j).getBm()) &&	//same birth month
						temp1.get(i).getBy().equals(temp1.get(j).getBy()) &&	//same birth year
						j != i)	{											//different students
					//print the list
					System.out.println(temp1.get(i).getFn() + " and " + temp1.get(j).getFn() + " " + temp1.get(j).getLn());

					//remove printed pairs
					temp1.remove(i);
					temp1.remove(j);
					size = size - 2;
				}
			}
		}
	}

	/**
	 * print a list of students born in a given month
	 * @param list the database of students
	 */
	public static void birthMonth(ArrayList<Student> list) {
		//declarations
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> temp = new ArrayList<Student>();
		String month = "";

		//determine the month
		System.out.println("Please choose a month (integers only):");
		month = scan.nextLine();

		//build the list
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBm().equals(month)) {
				temp.add(list.get(i));
				//System.out.println("someone was added to temp");	//check
			}
		}

		//print the list
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i).getLn() + ", "+ temp.get(i).getFn() + " (" + temp.get(i).getBd() + ")");
		}
	}

	/**
	 * print a list of students in a given house
	 * @param list the database of students
	 */
	public static void house(ArrayList<Student> list) {
		//declarations
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> advisorList = new ArrayList<Student>();
		String selection = "";

		//build the menu
		System.out.println("Please enter all or part of a house with correct capitalization:");
		selection = scan.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getAdv().contains(selection)) {
				//System.out.println("found someone"); //check
				advisorList.add(list.get(i));
			}
		}

		//print the advisor's name
		/* */if(advisorList.get(0).getAdv().contains("/")) System.out.println(advisorList.get(0).getAdv() + " House:");
		else System.out.println(advisorList.get(0).getAdv() + "'s House:");

		//print the list
		for (int i = 0; i < advisorList.size(); i++) {
			System.out.println(advisorList.get(i).getLn() + ", " + advisorList.get(i).getFn() + " (" + advisorList.get(i).grad + ")");
		}
	}

	/**
	 * print a sorted list of last names
	 * @param list the database of students
	 */
	public static void sortLast(ArrayList<Student> list) {
		ArrayList<String> last = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			last.add(list.get(i).getLn());
		}
		Collections.sort(last);

		for (int i = 0; i < last.size(); i++) {
			System.out.println(last.get(i));
		}
	}

	/**
	 * print the total number of male and female students
	 * @param list the database of students
	 */
	public static void genderCount(ArrayList<Student> list) {
		//declarations
		int counter_m = 0;
		int counter_f = 0;

		//iterate through the list
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).sex.equals("M")) {
				//System.out.println("found a dude");		//check
				counter_m++;
			}
			else if(list.get(i).sex.equals("F")) {
				//System.out.println("found a dudette"); 	//check
				counter_f++;
			}
		}

		//print the totals
		System.out.println("There are " + counter_m + " male students.");
		System.out.println("There are " + counter_f + " female students.");
	}

	/**
	 * compare the number of students in two given grades
	 * @param list the database of students
	 */
	public static void compareGrade(ArrayList<Student> list) {
		//declarations
		int counter_4 = 0;
		int counter_10 = 0;

		//iterate through the list
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).gr_cur.equals("4")) {
				//System.out.println("found a 4");		//check
				counter_4++;
			}
			else if(list.get(i).gr_cur.equals("10")) {
				//System.out.println("found a 10"); 	//check
				counter_10++;
			}
		}

		//print the totals
		System.out.println("There are " + counter_4 + " students in grade 4.");
		System.out.println("There are " + counter_10 + " students in grade 10.");
	}

	/**
	 * print the list of students born in 2001
	 * @param list the database of students
	 */
	public static void born2001(ArrayList<Student> list) {
		//declarations
		ArrayList<Student> temp = new ArrayList<Student>();
		String year = "2001";


		//build the list
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBy().equals(year)) {
				temp.add(list.get(i));
				//System.out.println("someone was added to temp");	//check
			}
		}

		//print the list
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i).getLn() + ", "+ temp.get(i).getFn() + " (" + temp.get(i).getBm() + "/" + temp.get(i).getBd() + ")");
		}
	}

	/**
	 * print a list of the top 10 first names in the database
	 * @param list the database of students
	 */
	public static void firstFrequency(ArrayList<Student> list) {
		//declarations
		Map<String, Integer> freq = new TreeMap<String, Integer>();

		//create the hashmap
		for(Student s : list) {
			if(!freq.containsKey(s.fn)) {
				freq.put(s.fn, 1);
			} else {
				freq.put(s.fn, freq.get(s.fn)+1);
			}
		}

		//sort
		freq = sortByValue(freq);

		//print top 10
		ArrayList<String> names = new ArrayList<String>(freq.keySet()); 
		ArrayList<Integer> values = new ArrayList<Integer>(freq.values()); 
		//		Collections.reverse(names);
		//		Collections.reverse(values);

		for (int i = 0; i < 10; i++) {
			System.out.println(names.get(i) + ": " + values.get(i));
		}
	}

	/**
	 * takes an unsorted hashmap and sorts it by value
	 * @param unsortMap the unsorted list of first names and their frequencies
	 * @return the sorted list of students and their frequencies
	 */
	public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {	 
		//declarations
		List list = new LinkedList(unsortMap.entrySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	/**
	 * print a list of students in a given grade
	 * @param list - the database of students
	 */
	public static void gradeLists(ArrayList<Student> list) {
		//declarations
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> gradeList = new ArrayList<Student>();
		String selection = "";

		//build the menu
		System.out.println("Please enter a grade:");
		selection = scan.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).gr_cur.contains(selection)) {
				//System.out.println("found someone"); //check
				gradeList.add(list.get(i));
			}
		}

		//print the advisor's name
		System.out.println("Grade " + selection + ":");

		//print the list
		for (int i = 0; i < gradeList.size(); i++) {
			System.out.println(gradeList.get(i).getLn() + ", " + gradeList.get(i).getFn() + " (" + gradeList.get(i).getAdv() + ")");
		}
	}
}