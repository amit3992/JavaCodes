package leetCode;
import java.util.*;

public class PowerSet {
	
	private static boolean checkBit(int x, int k) {
		return (x & 1 << k) != 0;
	}
	
	public static void printPowerSet(char[] set) {
		int size = set.length;
		int power_size = (int) Math.pow(2, new Double(size));
		int count = 0;
		
		for(count = 0; count < power_size; count++) {
			
			System.out.println("Count -> " + count);
			for(int j = 0; j < size; j++) {
				
				if(checkBit(count, j)) {
					System.out.print(set[j]);
				} 
				
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[] set = {'a','b','c'};
		printPowerSet(set);
	}

}
