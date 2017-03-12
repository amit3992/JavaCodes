package coursera.divideAndconquer;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        return -1;
    }
    
    private static int naiveGetMajorityElement(int [] a, int left, int right) {
    	
    	for(int i = left; i < right; i++) {
    		
    		int currentElement = a[i];
    		int count = 0;
    		
    		for(int j = left; j < right; j++) {
    			
    			if(currentElement == a[j]) 
    				count++;
    		}
    		
    		if(count > right/2) {
    			System.out.println("Majority element: " + currentElement + " is repeated " + count + " times!");
    			return 1; 
    		}
    		
     	}
    	
    	System.out.println("No majority element found!");
    	return -1;
    }
    
    private static int testGetMajorityElement(int[] a, int left, int right) {
    	
    	Arrays.sort(a);
    	int len = a.length;
    	int count = 0;
    	
    	for(int i = left; i < right; i++) {
    		if(a[i] == a[len/2])
    			count++;
    	}
    	
    	if(count > len/2)
    		return 1;
    	else
    		return -1;
    	
    }
    
    private static int getMajorityElementHashSet(int[] a, int left, int right) {
    	
    	HashSet<Integer> set = new HashSet<Integer>();
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int count = 0;
    	int maxCount = 0;
    	int n = a.length;
    	
    	for(int i = left; i < right; i++) {
    		
    		//System.out.println("====================");
    		//System.out.println("Element -> " + a[i]);
    		
    		if(!set.isEmpty()) {
    			
    			if(set.contains(a[i])) {
    			//	System.out.println(a[i] + " is present in set!");
    				count = map.get(a[i]);
    			//	System.out.println("Old count value of -> " + a[i] + " = " + count);
    				count = count+1;
    				
    				map.put(a[i], count);
    				//System.out.println("Count value of -> " + a[i] + " updated to -> " + map.get(a[i]));
    				
    				if(map.get(a[i]) > n/2) {
    					maxCount = count;
    					//System.out.println("Majority element found!! Element -> " + a[i] + " has a maxCount of " + maxCount);
    				}
        				
    			} 
    			
    			else {
    				//System.out.println("Element " + a[i] + " not present in set");
    				set.add(a[i]);
    				map.put(a[i], 1);
    				//System.out.println(a[i] + " added to map and set! Count set to 1");
    				
    			}
    				
    		}
    		else {
    			//System.out.println("Set empty!");
    			set.add(a[i]);
    			map.put(a[i], 1);
    			//System.out.println(a[i] + " added to map and set! Count set to 1");
    		}
    	}
    	
    	//System.out.println("Count: " + maxCount);
    	if(maxCount > n/2)
    		return 1;
    	else
    		return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        /*if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }*/
        
        /*if (naiveGetMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }*/
        
        /*if (testGetMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }*/
        if (getMajorityElementHashSet(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

