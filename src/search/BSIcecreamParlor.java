package search;
import java.util.*;


public class BSIcecreamParlor {
	
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		for(int i = 0; i < testCases; i++) {
			
			int sum = sc.nextInt();
			int n = sc.nextInt();
			
			map = new HashMap<Integer, Integer>();
			
			// Read flavors
			int[] flavors = new int[n];
			for(int j = 0; j < n; j++) {
				flavors[j] = sc.nextInt();
			}
			
			for(int p = 0; p < n; p++) {
				
				int comp = sum - flavors[p];
				
				if(map.containsKey(comp)) {
					System.out.println(map.get(comp) + " " + (p + 1));
					break;
				}
				else {
					map.put(flavors[p], p + 1);
				}
			}
			
		}

	}

}
