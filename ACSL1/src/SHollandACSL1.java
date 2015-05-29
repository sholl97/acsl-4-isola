import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Scanner;


public class SHollandACSL1 {
	public static void main(String[] args) {
		/***
		 * acsl contest 1
		 * @author sholland
		 * last updated 12-12-14
		 * 
		 * TODO:
		 * - fix else loop for when driver_a leaves before driver_b
		 * - optimize tot_dis if statements
		 * - optimize output print
		 * 
		 * input[0] = location start for driver a
		 * input[1] = location start for driver b
		 * input[2] = time start for driver a (number)
		 * input[3] = time start for driver a (am/pm)
		 * input[4] = time start for driver b (number)
		 * input[5] = time start for driver b (am/pm)
		 * input[6] = average speed for driver a
		 * input[7] = average speed for driver b
		 */

		//declarations
		Scanner scan = new Scanner(System.in);	
		DecimalFormat df = new DecimalFormat("#");

		String data = scan.nextLine();								//input from scanner
		String[] input = data.split(", ");							//splice and ignore case

		//check-in
		//System.out.println(input[0]);

		//variables from parsing
		int start_a = Integer.parseInt(input[2]);					//starting time for driver a
		if(input[3].equals("PM")) start_a += 12;					//if PM, convert to military
		int start_b = Integer.parseInt(input[4]);					//starting time for driver b
		if(input[5].equals("PM")) start_b += 12;					//if PM, convert to military
		int rate_a = Integer.parseInt(input[6]);					//average speed for driver a
		int rate_b = Integer.parseInt(input[7]);					//average speed for driver b

		//distance variables
		int tot_dis = 0;											//total distance between 2 origins
		double distance_a = 0;										//total distance for driver a
		double distance_b = 0;										//total distance for driver b

		//time variables
		double time_a = 0;											//total time for driver a
		double time_b = 0;											//total time for driver b

		//System.out.println("rate a: " + rate_a);					//check-in
		//System.out.println("rate b: " + rate_b);					//check-in

		//determine total distance
		int a_b = 450;
		int b_c = 140;
		int c_d = 125;
		int d_e = 365;
		int e_f = 250;
		int f_g = 160;
		int g_h = 380;
		int h_j = 235;
		int j_k = 320;
		//System.out.println("0: " + input[0]);						//check-in
		//System.out.println("1: " + input[1]);						//check-in
		if(input[0].equals("A")) {
			if(input[1].equals("B")) tot_dis = a_b;
			else if(input[1].equals("C")) tot_dis = a_b + b_c;
			else if(input[1].equals("D")) tot_dis = a_b + b_c + c_d;
			else if(input[1].equals("E")) tot_dis = a_b + b_c + c_d + d_e;
			else if(input[1].equals("F")) tot_dis = a_b + b_c + c_d + d_e + e_f;
			else if(input[1].equals("G")) tot_dis = a_b + b_c + c_d + d_e + e_f + f_g;
			else if(input[1].equals("H")) tot_dis = a_b + b_c + c_d + d_e + e_f + f_g + g_h;
			else if(input[1].equals("J")) tot_dis = a_b + b_c + c_d + d_e + e_f + f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = a_b + b_c + c_d + d_e + e_f + f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("B")) {
			if(input[1].equals("C")) tot_dis = b_c;
			else if(input[1].equals("D")) tot_dis = b_c + c_d;
			else if(input[1].equals("E")) tot_dis = b_c + c_d + d_e;
			else if(input[1].equals("F")) tot_dis = b_c + c_d + d_e + e_f;
			else if(input[1].equals("G")) tot_dis = b_c + c_d + d_e + e_f + f_g;
			else if(input[1].equals("H")) tot_dis = b_c + c_d + d_e + e_f + f_g + g_h;
			else if(input[1].equals("J")) tot_dis = b_c + c_d + d_e + e_f + f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = b_c + c_d + d_e + e_f + f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("C")) {
			if(input[1].equals("D")) tot_dis = c_d;
			else if(input[1].equals("E")) tot_dis = c_d + d_e;
			else if(input[1].equals("F")) tot_dis = c_d + d_e + e_f;
			else if(input[1].equals("G")) tot_dis = c_d + d_e + e_f + f_g;
			else if(input[1].equals("H")) tot_dis = c_d + d_e + e_f + f_g + g_h;
			else if(input[1].equals("J")) tot_dis = c_d + d_e + e_f + f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = c_d + d_e + e_f + f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("D")) {
			if(input[1].equals("E")) tot_dis = d_e;
			else if(input[1].equals("F")) tot_dis = d_e + e_f;
			else if(input[1].equals("G")) tot_dis = d_e + e_f + f_g;
			else if(input[1].equals("H")) tot_dis = d_e + e_f + f_g + g_h;
			else if(input[1].equals("J")) tot_dis = d_e + e_f + f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = d_e + e_f + f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("E")) {
			if(input[1].equals("F")) tot_dis = e_f;
			else if(input[1].equals("G")) tot_dis = e_f + f_g;
			else if(input[1].equals("H")) tot_dis = e_f + f_g + g_h;
			else if(input[1].equals("J")) tot_dis = e_f + f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = e_f + f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("F")){
			if(input[1].equals("G")) tot_dis = f_g;
			else if(input[1].equals("H")) tot_dis = f_g + g_h;
			else if(input[1].equals("J")) tot_dis = f_g + g_h + h_j;
			else if(input[1].equals("K")) tot_dis = f_g + g_h + h_j + j_k;
		}
		else if(input[0].equals("G")){
			if(input[1].equals("H")) tot_dis = g_h;
			else if(input[1].equals("J")) tot_dis = g_h + h_j;
			else if(input[1].equals("K")) tot_dis = g_h + h_j + j_k;
		}
		else if(input[0].equals("H")){
			if(input[1].equals("J")) tot_dis = h_j;
			else if(input[1].equals("K")) tot_dis = h_j + j_k;
		}
		else { /*(input[0].equals("J"))*/
			if(input[1].equals("K")) tot_dis = j_k;
		}
		System.out.println("tot_dis: " + tot_dis);					//check-in

		//cycle through each possibility to determine time_a / time_b
		int headstart = 0;
		int half_dis = 0;
		double output = 0;
		double out_round = 0;
		double out_min = 0;

		if(start_a==start_b) {										//if they both leave at the same time
			half_dis = tot_dis / 2;
			output = (double)half_dis / rate_a;
			//			System.out.println("output: " + output);							//check-in
			out_round = Math.floor(output - .5);
			out_min = (output % out_round)*60;			
			while(out_min>60) {
				out_round += 1;
				out_min -= 1;
			}
			System.out.println(df.format(Math.floor(out_round)) + ":" + Math.round(out_min)); //print out how long it takes
		}

		else {														//if driver a is the first driver to leave
			if(start_a > start_b) headstart = start_a - start_b;
			else headstart = start_b - start_a;
			//			System.out.println("headstart: " + headstart);
			//			System.out.println("rate_a: " + rate_a);
			half_dis = (tot_dis - (headstart * rate_a)) / 2;
			//			System.out.println("half_dis: " + half_dis);
			output = (double)half_dis / rate_a;
			//			System.out.println("output: " + output);							//check-in
			out_round = Math.floor(output - .4);
			//			System.out.println("out_round: " + out_round);
			out_min = (output % out_round)*60;
			//			System.out.println("out_min: " + out_min);
			while(out_min>60) {
				out_round += 1;
				out_min -= 1;
			}
			System.out.println(df.format(Math.floor(out_round)) + ":" + Math.round(out_min)); //print out how long it takes

		}

		/*time_a = tot_dis*time_a/2;
		System.out.println("old distance: " + distance_a);
		System.out.println("old rate: " + rate_a);
		System.out.println("old time: " + time_a);
		distance_a = rate_a * time_a;
		System.out.println("new distance: " + distance_a);
		System.out.println("new time: " + time_a);
		System.out.println("new rate: " + rate_a);
		//		for (int i = 0; i < input.length;) {
		//			for (int j = tot_dis; j > 0; j--) {
		//				System.out.print("i: " + i);
		//				System.out.println(" j: " + j);
		//				int time_sub = 60*(start_time_b - start_time_a);
		//				if(i==j+time_sub) {
		//					break;
		//				}
		//				i++;
		//			}
		//		}
		//			if(i==j) {
		//				rate_a = j;
		//				System.out.println("rate_a: " + rate_a);
		//				break;
		//			}
		//			i++;
		//			j--;
		//		}
		//		for (int i = 0; i < tot_dis; i++) {
		//			for (int j = tot_dis; j > 0; j--) {
		//				if(i==j) rate_a = j;
		//			}
		//		}
		//		System.out.println(rate_a);

		//determine individual distance
		//distance_a = rate_a * time_a;								//d = rt formula
		//distance_b = rate_b * time_b;								//d = rt formula

		//multiply distance by speed
		//distance_a *= rate_a;
		//distance_b *= rate_b;

		//take time_a and add it to the starting time
		double output = 5.5;

		//print out the final thing
		double out_hour = Math.round(output);
		double out_min = (output%(int)out_hour)*60;

		System.out.println("hour: " + df.format(out_hour));
		System.out.println("min: " + df.format(out_min));

		System.out.println(df.format(out_hour) + ":" + df.format(out_min));*/
	}
}