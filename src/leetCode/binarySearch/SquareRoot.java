package leetCode.binarySearch;
import java.util.*;


public class SquareRoot {
	
	static double episilon = 0.00001;
	
	public static double sqrt(double num) {
		
		if(num < 0) {
			return -1;
		}
		
		double low = 0;
		double high = 1 + (num/2);
		double mid = 0;
		
		while(low < high) {
			mid = low + (high - low)/2;
			
			double sq = mid * mid;
			double diff = Math.abs(num - sq);
			
			if(diff <= episilon) {
				return mid;
			} else if(sq < num) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		System.out.println("Square root -> " + sqrt(9));
	}

}
