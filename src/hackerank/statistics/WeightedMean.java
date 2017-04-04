package hackerank.statistics;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;


public class WeightedMean {
	
	static int[] weights;
	static int[] values;
	static int N;
	
	public static void readData(String line, int[] array) {
		
		StringTokenizer st = new StringTokenizer(line, " ");
		int i = 0;
		while(st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			array[i] = val;
			i++;
		}
	}
	
	public static Double getWeightedMean(int[] wts, int[] vals) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		double result;
		int sumWt = 0;
		int sumVals = 0;
		
		for(int i = 0; i < N; i++) {
			
			sumWt = sumWt + (wts[i] * vals[i]);
			sumVals = sumVals + vals[i];
			
		}
		
		result = (double)sumWt/(double)sumVals;
		
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		line = br.readLine();
		int n = Integer.parseInt(line);
		N = n;
		
		line = br.readLine();
		weights = new int[n];
		readData(line,weights);
		
		line = br.readLine();
		values = new int[n];
		readData(line, values);
		
		System.out.printf("%.1f",getWeightedMean(weights, values));
		
	}

	

}
