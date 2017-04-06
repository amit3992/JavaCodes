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
	static HashMap<String, Integer> magazineWords = new HashMap<String, Integer>();
	static HashMap<String, Integer> ransomeWords = new HashMap<String, Integer>();
	static int ransomWords = 0;
	
	public static void buildMap(String line) {
		StringTokenizer st = new StringTokenizer(line," ");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			if(magazineWords.get(s) == null) {
				magazineWords.put(s, 1);
			}
			else {
				magazineWords.put(s, magazineWords.get(s).intValue() + 1);
			}
		}
	}
	
	public static void checkRansomNote(String line) {
		StringTokenizer st = new StringTokenizer(line," ");
		int num = 0;
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			
			if(s!= null && magazineWords.get(s) != null) {
				num++;
				magazineWords.put(s, magazineWords.get(s).intValue() - 1);
			}
			else {
				magazineWords.put(s,1);
			}
			
		}
		
		if(num == ransomWords) {
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
		StringTokenizer st = new StringTokenizer(line, " ");
		int[] vals = new int[2];
        int i = 0;
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            vals[i] = Integer.parseInt(s);
            i++;
        }
        
        mapSize = vals[0];
        ransomWords = noteSize = vals[1];
		
		line = br.readLine();
		buildMap(line); // Build a hashmap of the words in sentence. Both, upper and lower case possible
		
		line = br.readLine();
		checkRansomNote(line); // Print 'YES' if robber can build a note from the words in map. else 'NO'

	}

}
