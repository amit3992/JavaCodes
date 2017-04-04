package hackerank.statistics;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


//64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
/*
 * 43900.6
44627.5
4978
 */

public class MeanMedianMode {
	
	
	
	public static String getMean(int[] array) {
		DecimalFormat df = new DecimalFormat("#.#");
		int size = array.length;
		int sum = 0;
		
		for(int i = 0; i < size; i++) {
			sum = sum + array[i];
		}
		
		double result = sum/(double)size;
		
		return df.format(result);
		
	}
	
	
	public static String getMedian(int [] array) {
		
		DecimalFormat df = new DecimalFormat("#.#");
		int size = array.length - 1;
		
		int a = size/2;
		int b = 0;
		int sum = 0;
		if(size % 2 != 0) {
			b = a + 1;
			
			sum = array[a] + array[b];
			
		}
		else {
			return df.format((double) array[a]);
		}
		
		return df.format((double)sum/2);
		
		
	}
    
    public static int getMode(int [] array) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int max = 1;
    	int temp = array[0];
    	
    	for(int i = 0; i < array.length; i++) {
    		if(map.get(array[i]) != null) {
    			int count = map.get(array[i]);
    			count += 1;
    			if(count > max) {
    				max = count;
    				temp = array[i];
    			}
    		}
    		else {
    			map.put(array[i], 1);
    		}
    	}
    	
    	return temp;
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int n = Integer.parseInt(line);
        int [] array = new int[n];
        line = br.readLine();
        int i = 0;
        
        StringTokenizer st = new StringTokenizer(line, " ");
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            array[i] = Integer.parseInt(s);
            i++;
        }
        
        Arrays.sort(array);
        System.out.println(getMean(array));
        System.out.println(getMedian(array));
        System.out.println(getMode(array));
        
    }
}