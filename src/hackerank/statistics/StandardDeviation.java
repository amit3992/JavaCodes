package hackerank.statistics;
import java.util.*;
import java.io.*;


public class StandardDeviation {
	
	static int [] values;
	static int N;
	static double mean;
	
	public static void readData(String line, int[] array) {
		StringTokenizer st = new StringTokenizer(line, " ");
		int i = 0;
		while(st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			array[i] = val;
			i++;
		}
	}
	
	public static void getMean(int [] array) {
		
		double result = 0.0;
		
		for(int i = 0; i < N; i++) {
			result = result + array[i];
		}
		
		mean = result/N;
	}
	
	public static double computeSD() {
		double result = 0.0;
		
		for(int i = 0; i < N; i++) {
			result = result + Math.pow((values[i] - mean), 2);
		}
		
		return Math.sqrt(result/N);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		line = br.readLine();
		N = Integer.parseInt(line);
		values = new int[N];
		
		line = br.readLine();
		readData(line, values);
		getMean(values);
		System.out.printf("%.1f", computeSD());
		
	}

}
