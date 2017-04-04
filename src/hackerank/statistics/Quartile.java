package statistics;
import java.util.*;
import java.io.*;

/*
 * 9
	3 7 8 5 12 14 21 13 18
	
	6
	12
	16
 */

public class Quartile {
	
	static int[] values;
	static int[] quartiles = new int[3];
	static int median = 0;
	static int medianPos = 0;
	
	public static void readData(String line) {
		StringTokenizer st = new StringTokenizer(line, " ");
		int i = 0;
		while(st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			values[i] = val;
			i++;
		}
	}
	
	public static int getMedian(int [] array) {
		
		int size = array.length - 1;
		
		int a = size/2;
		int b = 0;
		int sum = 0;
		if(size % 2 != 0) {
			b = a + 1;
			
			sum = array[a] + array[b];
			
		}
		else {
			return array[a];
		}
		
		return sum/2;
	}
	
	private static int[] getQuartiles() {
		
		int [] result = new int[3];
		int pos = Arrays.binarySearch(values, median);
		
		result[1] = median;
		
		int [] low = new int[pos];
		int [] high = new int[values.length - pos - 1];
		for(int i = 0; i < pos; i++) {
			low[i] = values[i];
		}
		
		for(int i = pos + 1; i < values.length; i++) {
			high[i - (pos + 1)] = values[i];
		}
		
		result[0] = getMedian(low);
		result[2] = getMedian(high);
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		line = br.readLine();
		int n = Integer.parseInt(line);
		
		values = new int[n];
		
		line = br.readLine();
		readData(line);
		Arrays.sort(values);
		
		median = getMedian(values);
		quartiles = getQuartiles();
		
		for(int i = 0; i < quartiles.length; i++) {
			System.out.println(quartiles[i]);
		}

	}

	

}
