package com.interviews.educative.hashing;
import java.util.*;

public class DisjointArrays {
	
	public static boolean isDisjoint(int[] arr1, int [] arr2) {
		
		Set<Integer> set = new HashSet<Integer>();
		/* Populate array 1 into set */
		for(int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		/* Check for common elements */
		for(int i = 0; i < arr2.length; i++) {
			if(set.contains(arr2[i])) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
