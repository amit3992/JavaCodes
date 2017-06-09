package hackerrank.algo.implementation;
import java.util.*;
import java.util.Map.Entry;

/* Link: https://www.hackerrank.com/challenges/migratory-birds */

/* ip: 6
	1 4 4 4 5 3
	op: 4
	
	Idea: count frequency of each type and print the most common (highest freq). Print lower index if two or more have the same frequency
	*/

public class MigratoryBirds {
	
	static HashMap<Integer, Integer> birdCount;
	
	static int migratoryBirds(int n, int[] ar) {
		
		birdCount = new HashMap<Integer, Integer>();
		int maxCount = Integer.MIN_VALUE;
		int maxType = 1;
		
		for(int i = 0; i < n; i++) {
			
			if(birdCount.containsKey(ar[i])) {
				int count = birdCount.get(ar[i]).intValue();
				count += 1;
				birdCount.put(ar[i], count);
				
			} else {
				birdCount.put(ar[i], 1);
			}
		}
		
		List<Entry> entryList = new ArrayList<Entry>(birdCount.entrySet());
		
		for (Entry temp : entryList) {
			
			if((int)temp.getValue() > maxCount) {
				maxCount = (int)temp.getValue(); 
				maxType = (int)temp.getKey();
			}
		}
		
        return maxType;
    }

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);

	}

}
