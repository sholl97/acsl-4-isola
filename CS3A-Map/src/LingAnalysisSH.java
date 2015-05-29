import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/***
 * 
 * @author sholland
 * cs3a-maps
 * initial submission 1/9/15
 */

public class LingAnalysisSH {
	public static void main(String[] args) {
		Path source = Paths.get("corpora/poe.txt");
		Path output = Paths.get("generated.txt");

		Map<String, Integer> freq = frequencyDist(source);
		System.out.println("frequencyDist: " + freq);
		//System.out.println("jesus: " + freq.get("jesus"));

		Map<Integer, Integer> wordleng = wordLengths(source);
		System.out.println("wordLengths: " + wordleng);

		Map<String, List<String>> bigram = bigram(source);
		System.out.println("bigram: " + bigram);

		Map<String, Integer> top10 = topTen(freq);
		System.out.println("top10: " + top10);
	}

	/*
	 * this should make a string of length words.
	 * 
	 * pick a first word from the keyset of gram
	 * repeat length times:
	 *    get the list associated with the word
	 *    replace word with a random pick from that list
	 *    add that word to the file
	 */
	static void generate(Map<String, List<String>> gram, int length, Path out) {
		try {
			BufferedWriter file = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			file.write("hello ");
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * this map should be from word length, to the number of words with that length.
	 * 
	 * for example, the output for tester.txt should be:
	 * {3=2, 5=1, 7=2} 
	 * in other words, there are two words of size three, one word of size 5, and two words of size 7
	 * 
	 */
	static Map<Integer, Integer> wordLengths(Path p) {
		Map<Integer, Integer> wordleng = new HashMap<Integer, Integer>();
		try {
			BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8);

			for(String line = br.readLine(); line!=null; line = br.readLine()) {
				//break line into words
				for (String word : line.split(" ")) {
					//System.out.println(word);
					word = word.replaceAll("[.,;:?&$%-/()*!\"]", "");						//exclude punctuation
					word = word.toLowerCase();												//remove capitalization
					word = word.replaceAll("'s?", "");
					word = word.replaceAll("[1234567890]", "");								//exclude numbers
					if(word.length()<3) continue;

					if(wordleng.containsKey(word.length())) wordleng.put(word.length(), wordleng.get(word.length())+1);
					else wordleng.put(word.length(), 1);
				}
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return wordleng;
	}

	/*
	 * This map should be from every word in the text to a list of words that can follow it.
	 * There should be multiple copies of the following words if they repeat in the text
	 * 
	 * the correct output for tester should be:
	 * 
	 * {two=[three], one=[two], testing=[testing, one]}
	 * 
	 * for each word:
	 *   if the previous word is not in the map, add it to the map with an empty list
	 *   get the previous word's list from the map, add the current word.x	
	 */
	static Map<String, List<String>> bigram(Path p) {
		Map<String, List<String>> bigram = new TreeMap<String, List<String>>();
		List data = new ArrayList<String>();
		List lis = new ArrayList<String>();

		try {
			BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8);

			for(String line = br.readLine(); line!=null; line = br.readLine()) {
				//break line into words
				for (String word : line.split(" ")) {
					word = word.replaceAll("[.,;:?&$%-/()*!\"]", "");						//exclude punctuation
					word = word.toLowerCase();												//remove capitalization
					word = word.replaceAll("'s?", "");
					word = word.replaceAll("[1234567890]", "");								//exclude numbers
					if(word.length()<1) continue;
					bigram.put(word, new ArrayList<String>());
					data.add(word);	
				}

				for (int i = 0; i < data.size(); i++) {
					if(i== data.size() - 1) break;
					bigram.get(data.get(i)).add((String) data.get(i+1));
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return bigram;
	}

	/*
	 * this map should be from every word to the frequency in the text
	 * 
	 * for each word:
	 *   if the word is in the map, increment the value by one
	 *   if the word is not in the map, add the word with a value of one.
	 */
	static Map<String, Integer> frequencyDist(Path p) {
		Map<String, Integer> freq = new TreeMap<String, Integer>();
		try {
			BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8);

			for(String line = br.readLine(); line!=null; line = br.readLine()) {
				//break line into words
				for (String word : line.split(" ")) {
					//System.out.println(word);
					word = word.replaceAll("[.,;:?&$%-/()*!\"]", "");						//exclude punctuation
					word = word.toLowerCase();												//remove capitalization
					word = word.replaceAll("'s?", "");
					word = word.replaceAll("[1234567890]", "");								//exclude numbers
					if(word.length()<3) continue;
					if(freq.containsKey(word)) freq.put(word, freq.get(word)+1);
					else freq.put(word, 1);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return freq;
	}

	static Map<String, Integer> topTen(Map<String, Integer> freq) {
		Map<String, Integer> top10 = new TreeMap<String, Integer>();
		List<Integer> tenn = new ArrayList<Integer>();

		top10.putAll(freq);																	//charlie wrote this

		for (int i = 0; i < freq.size(); i++) {											//i think this is necessary but i havent gotten to implementing it

		}

		return top10;
	}

}