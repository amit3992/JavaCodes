package graphs;
import java.util.*;

//4
//4
//1 1 0 0
//0 1 1 0
//0 0 1 0
//1 0 0 0

 // -> 5

public class DFSLargestGrid {
	
	private static int nRows;
	private static int nCols;
	
	public static int getLargest(int[][]grid) {
		int maxRegion = Integer.MIN_VALUE;
		
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; j++) {
				if(grid[i][j] == 1) {
					int size = findMax(grid, i, j);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		
		return maxRegion;
	}
	
	private static int findMax(int[][]grid, int row, int col) {
		// Run all checks
		if(row < 0 || row >= nRows || col < 0 || col >= nCols || grid == null || grid[row][col] == 0) {
			return 0;
		}
		
		// set grid to 0
		grid[row][col] = 0;
		int size = 1;
		
		for(int r = row-1; r <= row + 1; r++) {
			for(int c = col-1; c <= col+1; c++) {
				if(!(r == row && c == col)) {
					size += findMax(grid, r, c);
				}
			}
		}
		
		return size;
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nRows = sc.nextInt();
		nCols = sc.nextInt();
		
		int[][] grid = new int[nRows][nCols];
		
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		System.out.println("Size of largest region -> " + getLargest(grid));
	}

}
