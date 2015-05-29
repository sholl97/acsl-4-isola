import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author sholland
 * acsl 3 isola
 * last updated 4-17-15
 * SAMPLE DATA
 * 46, 4, 45, 47, 38, 40, 0
 */

public class SHAcsl3 {
	public static void main(String[] args) {
		//declarations
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		int[][] board = new int[7][7];
		//boolean[][] boardIsEmpty = new boolean[7][7];
		int player1 = Integer.parseInt(input[0]);	//+
		int player2 = Integer.parseInt(input[1]);	//X
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		ArrayList<Integer> blockadeSurround = new ArrayList<Integer>();
		ArrayList<Integer> blockadeAdjacent = new ArrayList<Integer>();
		ArrayList<Integer> blockadePath = new ArrayList<Integer>();
		int temp = 0;
		scan.close();

		//fill the board with emptiness
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}

		//initial position for player 1
		if(player1 % 7==0) {
			x1 = 6;
			y1 = player1 / 7-1;
			//System.out.println("player1 is at (" + x1 + "," + y1 + ")");
		}
		else {
			x1 = player1 % 7-1;
			y1 = player1 / 7;
			//System.out.println("player1 is at (" + x1 + "," + y1 + ")");
		}

		//initial position for player 2
		if(player2 % 7==0) {
			x1 = 6;
			y1 = player2 / 7-1;
			//System.out.println("player2 is at (" + x2 + "," + y2 + ")");
		}
		else {
			x1 = player2 % 7-1;
			y1 = player2 / 7;
			//System.out.println("player2 is at (" + x2 + "," + y2 + ")");
		}

		//setup starting positions
		board[x1][y1] = player1;
		board[x2][y2] = player2;

		//setup barrier(s)
		for (int i = 2; i < input.length-1; i++) {
			int num = Integer.parseInt(input[i]);
			if(num%7==0) {
				board[6][num/7-1] = 9;			//set the barrier in the first row
				//System.out.println("block at " + num);
			}
			else {
				board[num % 7-1][num / 7] = 9;	//set the barrier in all other rows
				//System.out.println("block at " + num);
			}
		}

		//print the board
		/*for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j]);
				if(j < board[i].length - 1) System.out.print(" ");
			}
			System.out.println();
		}*/


		//possible cases
		//far right
		if(x1==6) {
			if(y1==6) { //bot left
				if(board[5][6]==0) {
					temp = 48;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
				if(board[6][5]==0) {
					temp = 42;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
				if(board[5][5]==0) {
					temp = 41;
					blockadeSurround.add(temp);
				}
			}
			else if(y1==0) { //bot right
				if(board[5][0]==0) {
					temp = 6;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
				if(board[6][1]==0) {
					temp = 14;
					blockadeSurround.add(temp);
					blockadeSurround.add(temp);
				}
				if(board[5][1]==0) {
					temp = 13;
					blockadeSurround.add(temp);
				}
			}
			else { //move somewhere else
				if(board[6][y1+1]==0) { //up
					blockadeSurround.add(player1 + 7);
					blockadeAdjacent.add(player1 + 7);
				}
				if(board[6][y1-1]==0) { //down
					blockadeSurround.add(player1 - 7);
					blockadeAdjacent.add(player1 - 7);
				}		
				if(board[5][y1]==0) { //left straight
					blockadeSurround.add(player1 - 1);
					blockadeAdjacent.add(player1 - 1);
				}
				if(board[5][y1+1]==0) { //left diag
					blockadeSurround.add(player1 + 6);
				}
				if(board[5][y1-1]==0) { //left diag down
					blockadeSurround.add(player1 - 8);
				}
			}
		}
		//far left
		else if(x1 == 0) {
			if(y1 == 0) {//left bot
				if(board[0][1]==0) {
					temp = 8;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
				if(board[1][1]==0) {
					temp = 9;
					blockadeSurround.add(temp);
				}
				if(board[1][0]==0) {
					temp = 2;
					blockadeSurround.add(temp); 
					blockadeAdjacent.add(temp);
				}
			}
			else if(y1 == 6) {
				if(board[0][5]==0) {
					temp = 36;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
				if(board[1][5]==0) {
					temp = 37;
					blockadeSurround.add(temp);
				}
				if(board[1][5]==0) {
					temp = 44;
					blockadeSurround.add(temp);
					blockadeAdjacent.add(temp);
				}
			}	
			else{
				if(board[0][y1+1]==0) { //up
					blockadeSurround.add(player1 + 7);
					blockadeAdjacent.add(player1 + 7);
				}
				if(board[0][y1-1]==0) { //down
					blockadeSurround.add(player1 - 7);
					blockadeAdjacent.add(player1 - 7);
				}		
				if(board[1][y1]==0) { //right
					blockadeSurround.add(player1 + 1);
					blockadeAdjacent.add(player1 + 1);
				}
				if(board[1][y1+1]==0) { //right diagonal up
					blockadeSurround.add(player1 + 8);
				}
				if(board[1][y1-1]==0) { //right diagonal down
					blockadeSurround.add(player1 - 6);
				}
			}
		}

		else if(y1==0) {//bottom
			if(board[x1-1][0]==0) { //left
				blockadeSurround.add(player1 - 1);
				blockadeAdjacent.add(player1 - 1);
			}
			if(board[x1+1][0]==0) { //right
				blockadeSurround.add(player1 + 1);
				blockadeAdjacent.add(player1 + 1);
			}		
			if(board[x1][1]==0) { //up
				blockadeSurround.add(player1 + 7);
				blockadeAdjacent.add(player1 + 7);
			}
			if(board[x1-1][1]==0) { //left diagonal up
				blockadeSurround.add(player1 + 6);
			}
			if(board[x1+1][1]==0) { //right diagonal up
				blockadeSurround.add(player1 + 8);
			}
		}
		else if(y1 == 6) {//top
			if(board[x1-1][6]==0) { //left
				blockadeSurround.add(player1 - 1);
				blockadeAdjacent.add(player1 - 1);
			}
			if(board[x1+1][6]==0) { //right
				blockadeSurround.add(player1 + 1);
				blockadeAdjacent.add(player1 + 1);
			}		
			if(board[x1][5]==0) { //down
				blockadeSurround.add(player1 - 7);
				blockadeAdjacent.add(player1 - 7);
			}
			if(board[x1-1][5]==0) { //left diagonal down
				blockadeSurround.add(player1 - 8);
			}
			if(board[x1+1][5]==0) { //right diagonal up
				blockadeSurround.add(player1 - 6);
			}
		}
		else {//other cases
			if(board[x1][y1+1]==0) { //one up
				blockadeSurround.add(player1 + 7);
				blockadeAdjacent.add(player1 + 7);
			}
			if(board[x1][y1-1]==0) { //one down
				blockadeSurround.add(player1 - 7);
				blockadeAdjacent.add(player1 - 7);
			}
			if(board[x1-1][y1]==0) { //left
				blockadeSurround.add(player1 - 1);
				blockadeAdjacent.add(player1 - 1);
			}
			if(board[x1+1][y1]==0) { //right
				blockadeSurround.add(player1 + 1);
				blockadeAdjacent.add(player1 + 1);
			}
			if(board[x1+1][y1-1]==0) { //right diagonal down
				blockadeSurround.add(player1 - 6);
			}	
			if(board[x1+1][y1+1]==0) { //right diagonal up
				blockadeSurround.add(player1 + 8);
			}	
			if(board[x1-1][y1-1]==0) { //left diagonal down
				blockadeSurround.add(player1 - 8);
			}	
			if(board[x1-1][y1+1]==0) { //left diagonal up
				blockadeSurround.add(player1 + 6);
			}
		}


		//no possible movements
		if(blockadeSurround.size()>3 || blockadeSurround.size()==0 || blockadeAdjacent.size()==3 || blockadeSurround.size()-blockadeAdjacent.size()>=3) {
			System.out.println("NONE");
		}

		//possible movements
		else {

			//3 in a row
			if(blockadeSurround.size()==3) {
				int avg = 0;
				Collections.sort(blockadeSurround);
				for(int n : blockadeSurround) {
					avg += n; 
				}
				if (avg/3==blockadeSurround.get(1)) {
					if(blockadeSurround.get(1)-blockadeSurround.get(0)==1) {
						if(player2 < blockadeSurround.get(0)) { //right
							while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=6) {
								x2 += 1;
								blockadePath.add(player2);
								player2 += 1; 
							}
							blockadePath.remove(0); 
							System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
						}
						else { //keep going left
							while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0 ) {
								x2 -= 1;
								blockadePath.add(player2);
								player2 -= 1;
							}
							blockadePath.remove(0); 
							System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
						}
					}
					else if(blockadeSurround.get(1)-blockadeSurround.get(0)==7) {
						if(player2 < blockadeSurround.get(0)) { //keep going up
							while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 &&  y2!=6){
								y2 += 1;
								blockadePath.add(player2);
								player2 += 7;
							}
							blockadePath.remove(0); 
							System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
						}
						else {//keep going down
							while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && y2!=0) {
								y2 -= 1;
								blockadePath.add(player2);
								player2 -= 1;
							}
							blockadePath.remove(0); 
							System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
						}
					}
				}
			}
			//2 adjacent
			else if(blockadeAdjacent.size()==2) {
				Collections.sort(blockadeAdjacent);
				if(blockadeAdjacent.get(1) - blockadeAdjacent.get(0) == 8){  
					if(player2 < blockadeSurround.get(0)){ //up right diag
						player2 += 8;
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0 && y2!=0) {
							x2 += 1;
							y2 += 1; 
							blockadePath.add(player2);
							player2 += 8;
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else { //down left diag
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0 && y2!=0) {
							x2 -= 1;
							y2 -= 1; 
							blockadePath.add(player2);
							player2 -= 8;
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
				else if(blockadeAdjacent.get(1)-blockadeAdjacent.get(0)==6) {
					if(player2 < blockadeSurround.get(0)) { //up diag
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0 && y2!=6){ 
							blockadePath.add(player2);
							player2 += 6;
							x2 -= 1;
							y2 += 1;
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else { //down diag
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=6 && y2!=0) {
							x2 += 1;
							y2 -= 1; 
							blockadePath.add(player2);
							player2 -= 6;
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
				else {
					System.out.println("NONE");
				}
			}
			//adjacent and diagonal
			else if(blockadeAdjacent.size()==1 && blockadeSurround.size()==2) {
				if(player2 < blockadeSurround.get(0)) { //right
					while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!= player1 && x2 != 6){
						x2 += 1; 
						blockadePath.add(player2);
						player2 += 1;
					}
					blockadePath.remove(0); 
					System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
				}
				else { //keep going left
					while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0) {
						x2 -= 1;
						blockadePath.add(player2);
						player2 += 1; 
					}
					blockadePath.remove(0); 
					System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
				}
			}
			//one adjacent movement
			else if(blockadeAdjacent.size()==1 && blockadeSurround.size()==1) {
				if(player2 < blockadeSurround.get(0)) { //up and right
					if(x1 == x2) {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && y2!=6) {
							y2 += 1;
							blockadePath.add(player2);
							player2 += 7; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=6) {
							x2 += 1;
							blockadePath.add(player2);
							player2 += 1; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
				else { //down or left
					if(x1 == x2) {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && y2!=0) {
							y2 -= 1;
							blockadePath.add(player2);
							player2 -= 7; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0) {
							x2 -= 1;
							blockadePath.add(player2);
							player2 -= 1; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
			}

			//one diagonal movement
			if(blockadeAdjacent.size()==0 && blockadeSurround.size()==1) {
				if(x2 < x1) {
					if(player2 < player1) {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=6 && y2!=6) {
							x2 += 1;
							y2 += 1;
							blockadePath.add(player2);
							player2 += 8;
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else { 
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=6 && y2!=0) {
							x2 += 1;
							y2 -= 1;
							blockadePath.add(player2);
							player2 -= 6; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
				else {
					if(player2 < player1) {
						while(board[x2][y2] != player1 && board[x2][y2]!=9 && player2!=player1){
							x2 -= 1;
							y2 +=1; 
							blockadePath.add(player2);	
							player2 += 6; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
					else {
						while(board[x2][y2]!=player1 && board[x2][y2]!=9 && player2!=player1 && x2!=0 && y2!=0) {
							x2 -= 1;
							y2 -=1;
							blockadePath.add(player2);
							player2 -= 8; 
						}
						blockadePath.remove(0); 
						System.out.println(blockadePath.toString().replaceAll("[\\[\\]]",""));
					}
				}
			}
			else {
				System.out.println("NONE");
			}
		}
	}
}