package leetCode.Arrays;
import java.util.Scanner;

public class RotateArray {
	
	public static void rotateArray(int[] arr, int order) {	
		if (arr == null || arr.length==0 ) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		
		order = order % arr.length;
		System.out.println(order % arr.length);
		if(order < 0) {
			order = order + arr.length;
			System.out.println(order);
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,4,5,6,7};
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		rotateArray(array, k);

	}

}
