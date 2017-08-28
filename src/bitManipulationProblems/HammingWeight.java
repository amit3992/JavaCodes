package bitManipulationProblems;
import java.util.*;

public class HammingWeight {
	
	public static int getHW(int num) {
		if(num < 0) {
			return -1;
		}
		
		int count = 0;
		while(num != 0) {
			count = count + (num & 1);
			System.out.println("Num before -> " + num);
			num = num >>> 1;
			System.out.println("Num after -> " + num);
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		int num = 5;
		int result = getHW(num);
		
		System.out.println("Result : " + result);

	}

}
