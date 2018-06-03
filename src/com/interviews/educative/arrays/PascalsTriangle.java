package com.interviews.educative.arrays;

public class PascalsTriangle {
	
	public static void printPascalTriangle(int n) {
		
		int [][] array = new int[n][n];
		
		for(int row = 0; row < n; row++) {
			
			for(int col = 0; col <= row; col++) {
				
				if(row == col || col == 0) {
					array[row][col] = 1;
				} else {
					array[row][col] = array[row - 1][col - 1] + array[row - 1][col];
				}
				
				System.out.print(array[row][col]);
			}
			
			System.out.println();
		}
	}
	
	public static int [] getPascalRow(int n) {
		
		/* Edge case */
		if(n <= 0) {
			return new int[0];
		}
		
		/* Declare a table */
		int [][] T = new int [n][n];
		
		for(int row = 0; row < n; row++) {
			
			for(int col = 0; col <= row; col++) {
				
				if(row == col || col == 0) {
					T[row][col] = 1;
				} else {
					T[row][col] = T[row - 1][col - 1] + T[row - 1][col];
				}
			}
		}
		
		return T[n - 1];
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//printPascalTriangle(6);
		
		int [] result = getPascalRow(2);
		for(int val : result) {
			System.out.print(val + " ");
		}

	}

}
