package graphs;
import java.util.*;

public class MatrixDFS {
	
	private static int runDFS(int[][] grid, int i, int j) {
		int size = 0;
		
		grid[i][j] = 0; // Mark this cell as visited
		
		for(int row = i-1; row <= i+1; row++) {
			for(int col = j-1; col <= j+1; col++) {
				
				if(row >= 0 && row < grid.length && col >= 0 && col < grid[i].length && grid[row][col] == 1) {
					size += runDFS(grid, row, col);
				}
			}
		}
		
		return size;
	}
	
	public static int getBiggestRegion(int[][] grid) {
		int largest = Integer.MIN_VALUE;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					int sum = runDFS(grid, i, j);
					largest = Math.max(largest, sum);
				}
			}
		}
		
		return largest;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
        
	}

}
