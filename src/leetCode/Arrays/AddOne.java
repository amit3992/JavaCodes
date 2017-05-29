package leetCode.Arrays;
import java.util.*;

public class AddOne {
	
	public static void addOne(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		int len = array.length;
		int carry = 0;
		
		for(int i = len-1; i >= 0; i--) {
			
			int a = array[i];
			int sum = a + 1;
			if(sum > 9) {
				carry = 1;
				array[i] = sum % 10;
			} else {
				carry = 0;
				array[i] = array[i] + carry;
			}
		}
		
		if(carry == 0) {
			System.out.println("Result");
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		} else {
			int [] result = new int[len + 1];
			result[0] = 1;
			for(int i = 0; i < array.length; i++) {
				result[i + 1] = array[i];
			}
			
			System.out.println("Result");
			
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}
	public static void main(String[] args) {
		
		int [] num1 = {1, 2, 4};
		int[] num2 = {0, 9, 0};
		int[] num3 = {0, 1, 2, 4};
		int[] num4 = {9, 9, 9};
		
		addOne(num1);
		

	}

}
