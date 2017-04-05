package hashmap;
import java.util.*;
import java.io.*;

/*
 * ip:
 * 6
 * 4
 * give me one grand today night
 * give one grand today
 * 
 * op:
 * YES
 * 
 */

public class RansomNote {
	
	static int mapSize;
	static int noteSize;
	HashMap<Integer, String> wordMap;
	
	public static void buildMap(String line) {
		StringTokenizer st = new StringTokenizer(line," ");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			// get unique hash value for s
			// put key-> hash value, value -> string
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = br.readLine();
		mapSize = Integer.parseInt(line);
		
		line = br.readLine();
		noteSize = Integer.parseInt(line);
		
		line = br.readLine();
		buildMap(line); // Build a hashmap of the words in sentence. Both, upper and lower case possible
		
		line = br.readLine();
		checkRansomNote(line); // Print 'YES' if robber can build a note from the words in map. else 'NO'

	}

}
