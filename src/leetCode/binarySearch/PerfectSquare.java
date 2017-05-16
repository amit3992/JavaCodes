package leetCode.binarySearch;
import java.util.*;

public class PerfectSquare {
	
	public static boolean isPerfectSquare(int num) {
		
		if(num == 1) {
			return true;
		}
		
		int start = 0;
		int end = num/2;
		
		while(start <= end) {
			long mid = (start + end)/2;
			
			if(mid * mid == num) {
				return true;
			} else if(mid * mid < num) {
				start = (int)mid + 1;
			} else {
				end = (int)mid - 1;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {

			int num = sc.nextInt();
			if(num <= 0) {
				throw new Exception("Input cannot be zero or negative!");
			} else {
				System.out.println(isPerfectSquare(num));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
