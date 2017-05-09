package leetCode.Arrays;
import java.util.*;

public class UnionIntersection {
	
	public static void showUnion(int[] a, int[] b, int aL, int bL) {
		int i = 0;
		int j = 0;
		
		while(i < aL && j < bL) {
			
			if(a[i] < b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else if(a[i] > b[j]) {
				System.out.print(b[j] + " ");
				j++;
			} else {
				System.out.print(b[j] + " ");
				i++;
				j++;
			}
		}
		
		/*Print rest of the array*/
		while(i < aL) {
			System.out.print(a[i] + " ");
			i++;
		}
		
		while(j < bL) {
			System.out.print(b[j] + " ");
			j++;
		}
	}
	
	public static void showIntersection(int[] a, int[] b, int aL, int bL) {
		int i = 0;
		int j = 0;
		
		while(i < aL && j < bL) {
			if(a[i] == b[j]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
	}

	public static void main(String[] args) {
		
		int[] array1 = {1,2,4,5,6};
		int[] array2 = {2,3,5,7};
		
		int aLen = array1.length;
		int bLen = array2.length;
		
		System.out.print("Union -> ");
		showUnion(array1, array2, aLen, bLen);
		System.out.println();
		System.out.print("Intersection -> ");
		showIntersection(array1, array2, aLen, bLen);
		
	}

}
