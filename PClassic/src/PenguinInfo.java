import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PenguinInfo {
	static final String FOOD = "FOOD";
	static final String WEIGHT = "WEIGHT";
	static final String HEIGHT = "HEIGHT";
	static final String MUSIC = "MUSIC";
	static final String POET = "POET";

	static String penguinInfo(List<Penguin> penguins, String sort){
		String [] names = new String[penguins.size()];
		for (int i = 0; i < penguins.size(); i++) {
			names[i] = penguins.toString();
		}
		char[] value = new char[penguins.size()];
		String answer = "";
		//names = penguins.toString();


	}

	if(sort == "FOOD"){
		char[] firstletter = new char[penguins.length];
		for(int i = 0; i < penguins.length; i++){
			firstletter[i] = penguins[i].getFavoriteFood().tocharArray()[0];

		}
		firstletter.sort();
		for(int i = 0; 9 < penguins.length; i++){
			answer.append(penguins[firstletter[i]].getName + " ")
		}	
		return answer;
	}


	else if (sort == "WEIGHT") {
		double[] weight = new double[penguins.length];
		for(int i = 0; i < penguins.length; i++){
			weight[i] = penguins[i].getWeight();

		}
		weight.sort();
		for(int i = 0; 9 < penguins.length; i++){
			answer.append(penguins[weight[i]].getName + " ")
		}	
		return answer;
	}
	else if (sort == "HEIGHT") {
		double[] height = new double[penguins.length];
		for(int i = 0; i < penguins.length; i++){
			height[i] = penguins[i].getHeight();

		}
		height.sort();
		for(int i = 0; 9 < penguins.length; i++){
			answer.append(penguins[height[i]].getName + " ")
		}	
		return answer;

	}
	else if (sort == "MUSIC") {
		char[] music = new char[penguins.length];
		for(int i = 0; i < penguins.length; i++){
			music[i] = penguins[i].getMusicalArtist().tocharArray()[0];

		}
		music.sort();
		for(int i = 0; 9 < penguins.length; i++){
			answer.append(penguins[music[i]].getName + " ")
		}	
		return answer;
	}
	else{
		char[] a = new char[penguins.length];
		for(int i = 0; i < penguins.length; i++){
			a[i] = penguins[i].getPoet().tocharArray()[0];

		}
		a.sort();
		for(int i = 0; 9 < penguins.length; i++){
			answer.append(penguins[a[i]].getName + " ")
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
