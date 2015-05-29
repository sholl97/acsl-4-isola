import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class PenguinInfo {
	static final String FOOD = "FOOD";
	static final String WEIGHT = "WEIGHT";
	static final String HEIGHT = "HEIGHT";
	static final String MUSIC = "MUSIC";
	static final String POET = "POET";

	static String penguinInfo(List<Penguin> penguins, String sort){
		//public String whatever = sort;
		String [] names = new String[penguins.size()];
		char[] value = new char[penguins.size()];
		String answer = "";
		//names = penguins.toString();



		String[] firstletter = new String[penguins.size()];
		double[] weight = new double[penguins.size()];
		double[] height = new double[penguins.size()];
		String[] music = new String[penguins.size()];
		String[] poet = new String[penguins.size()];
		String[] sorted = new String[penguins.size()];
		double[] dubsorted = new double[penguins.size()];

		if (sort.equals("FOOD")){
			for(int i = 0; i < penguins.size(); i++){
				firstletter[i] = penguins.get(i).getFavoriteFood();

			}
			Arrays.sort(firstletter);	
			//sorted = firstletter.sort();
			for(int i = 0; i < penguins.size(); i++){
				for(int j = 0; j < penguins.size(); j++){
					if(firstletter[i].equals(penguins.get(j).getName())){
						answer = (penguins.get(j).getName() + " ");
					}
				}
			}	
			return answer;
		}

		else if (sort.equals("WEIGHT")) {
			for(int i = 0; i < penguins.size(); i++){
				weight[i] = penguins.get(i).getWeight();

			}	
			Arrays.sort(weight);
			for(int i = 0; i < penguins.size(); i++){
				for(int j = 0; j < penguins.size(); j++){

					if(weight[i] == penguins.get(j).getWeight()){
						answer = penguins.get(j).getName() + " ";
					}
				}
			}
			return answer;
		}

		else if (sort.equals("HEIGHT")) {
			for(int i = 0; i < penguins.size(); i++){
				height[i] = penguins.get(i).getHeight();

			}
			Arrays.sort(height);
			for(int i = 0; i < penguins.size(); i++){
				for(int j = 0; j < penguins.size(); j++){

					if(height[i] == penguins.get(j).getHeight()){
						answer = (penguins.get(j).getName() + " ");
					}
				}
			}	
			return answer;
		}

		else if (sort.equals("MUSIC")) {
			for(int i = 0; i < penguins.size(); i++){
				music[i] = penguins.get(i).getMusicalArtist();

			}
			Arrays.sort(music);
			for(int i = 0; i < penguins.size(); i++){
				for(int j = 0; j < penguins.size(); j++){

					if(music[i].equals(penguins.get(j).getMusicalArtist())){
						answer.append(penguins.get(j).getName() + " ");
					}
				}
			}
			return answer;
		}

		else {
			for(int i = 0; i < penguins.size(); i++){
				poet[i] = penguins.get(i).getPoet();

			}
			Arrays.sort(poet);
			for(int i = 0; i < penguins.size(); i++){
				for(int j = 0; j < penguins.size(); j++){

					if(poet[i].equals(penguins.get(j).getPoet())){
						answer.append(penguins.get(j).getName() + " ");
					}
				}
			}
			return answer;
		}
	}

	//Class which represents Penguins
	static public class Penguin{
		final String name;
		final String favoriteFood;
		final double weight;
		final double height;
		final String musicalArtist;
		final String poet;		

		public Penguin(String name, String favoriteFood, double weight,
				double height, String musicalArtist, String poet){
			this.name = name;
			this.favoriteFood = favoriteFood;
			this.weight = weight;
			this.height = height;
			this.musicalArtist = musicalArtist;
			this.poet = poet;
		}

		public String getName() {
			return name;
		}

		public String getFavoriteFood() {
			return favoriteFood;
		}

		public double getWeight() {
			return weight;
		}

		public double getHeight() {
			return height;
		}

		public String getMusicalArtist() {
			return musicalArtist;
		}

		public String getPoet() {
			return poet;
		}

		public String toString() {
			return name;
		}

	}


	//main method for reading input for text files
	//--------------------------------------
	//Format for text files:
	//END OF PROBLEM
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("PenguinInfoIN.txt"));
		List<Penguin> penguins = new LinkedList<Penguin>();
		while(in.hasNext()){
			String next = in.nextLine();
			while(!next.equals("*****")){
				penguins.add(new Penguin(next,in.nextLine(),Double.parseDouble(in.nextLine()),Double.parseDouble(in.nextLine()),in.nextLine(),in.nextLine()));
				next = in.nextLine();
			}
			System.out.println(penguinInfo(penguins,in.next()));
			penguins.clear();
			if(in.hasNext()){
				in.nextLine();
			}
		}
	}
}
