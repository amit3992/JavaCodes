package leetCode;
import java.util.*;

//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

public class RotateRight {
	
	public static int[] rotateArray(int[] array, int k) {
		int n = array.length;
		int[] newArray = new int[k];
		
		for(int i = 0; i < k; i++) {
			newArray[i] = array[n - k + i];
		}
		
		System.arraycopy(array,0, array, 3, n-k);
		
		for(int i = 0; i < k; i++) {
			array[i] = newArray[i];
		}
		
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,4,5,6,7};
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		array = rotateArray(array, k);
		
		for(int i = 0; i < k; i++) {
			System.out.print(array[i] + " ");
		}
		

	}

}
