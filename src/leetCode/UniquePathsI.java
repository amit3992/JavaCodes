package leetCode;

import java.util.Scanner;

public class UniquePathsI {
	
	public static int getPaths(int m, int n) {
		int[][] grid = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		
		for(int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		
		for(int row = 1; row < m; row++) {
			for(int col = 1; col < n; col++) {
				grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
			}
		}
		
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println("Total paths -> " + getPaths(m,n));
		sc.close();

	}

}
