package code;
import java.util.*;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{1, 2, 4, 6, 7};
		int [] arr2 = new int[] {3, 5, 8, 9, 10};
		
		Object[] mergedArray = mergeSortedArrays(arr1, arr2);
		
		for(int i = 0; i < mergedArray.length; i++) {
			System.out.print(mergedArray[i] + " ");
		}
	}

	private static Object[] mergeSortedArrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int [] mergedArray = new int[n1 + n2];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		
		while(i <= n1 && j <= n2) {
			System.out.println("Here");
			if(arr1[i] < arr2[j]) {
				System.out.println("In i");
				list.add(arr1[i]);
				System.out.println("List: " + list.toString());
				i++;
				if(i >= n1)
					i = n1-1;
				System.out.println("i -> " + i);
				continue;
			}
			if(arr1[i] > arr2[j]) {
				System.out.println("In j");
				list.add(arr2[j]);
				System.out.println("List: " + list.toString());
				j++;
				if(j >= n2)
					j = n2-1;
				System.out.println("j -> " + j);
				continue;
			}
			if(arr1[i] == arr2[j]) {
				System.out.println("In =");
				list.add(arr1[i]);
				i++;
				j++;
				if(i >= n1) i = n1-1;
				if(j >= n2) j = n2-1;
				break;
			}
		}
		
		return list.toArray();
		
	}

}
