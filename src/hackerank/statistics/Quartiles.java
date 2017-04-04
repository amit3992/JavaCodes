package hackerank.statistics;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;


public class Quartiles {
	
	static int[] values;
	static int N;
	static double median;
	
	public static void getMedian(int [] array) {
		
		int size = array.length - 1;
		
		int a = size/2;
		int b = 0;
		int sum = 0;
		if(size % 2 != 0) {
			b = a + 1;
			
			sum = array[a] + array[b];
			
		}
		else {
			median = (double) array[a];
		}
		
		median = (double)sum/2 ;
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		line = br.readLine();
		N = Integer.parseInt(line);
		values = new int[N];
		
		
		
		

	}

}
