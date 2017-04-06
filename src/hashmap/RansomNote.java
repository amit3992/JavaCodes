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
	static HashMap<Integer, String> wordMap = new HashMap<Integer, String>();
	
	public static void buildMap(String line) {
		StringTokenizer st = new StringTokenizer(line," ");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			int hashCode = s.hashCode() % 101;
			wordMap.put(hashCode,s);
		}
	}
	
	public static void checkRansomNote(String line) {
		StringTokenizer st = new StringTokenizer(line," ");
		boolean flag = true;
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			int hashCode = s.hashCode() % 101;
			if(wordMap.containsKey(hashCode)) {
				//System.out.println("MAP CONTAINS " + s);
				continue;
			}
			else {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
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
