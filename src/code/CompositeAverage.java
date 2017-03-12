package code;
import java.util.*;
import java.io.*;

public class CompositeAverage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = in.readLine();
		
		System.out.println(line);
		
		line = in.readLine();
		String[] arr = line.split(",");
		int[] numarr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			numarr[i] = Integer.parseInt(arr[i]);
		}
		
		System.out.println(numarr[0]+" "+numarr[1]+" "+numarr[2]+" "+numarr[3]);

	}

}
