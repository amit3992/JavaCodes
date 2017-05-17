package leetCode.graph;

public class CountingIslands {
	
	public static int countIslands(int[][] grid) {
		
		int count = 0;
		int nRows = grid.length;
		int nCols = grid[0].length;
		
		for(int row = 0; row < nRows; row++) {
			for(int col = 0; col < nCols; col++) {
				if(grid[row][col] == 1) {
					count++;
					countIslandsUtil(grid, row, col);
				}
			}
		}
		
		return count;
	}
	
	private static void countIslandsUtil(int[][] grid, int i, int j) {
		
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			return;
		}
		
		//Mark grid co-ordinate to 0
		grid[i][j] = 0;
		
		countIslandsUtil(grid, i+1, j);
		countIslandsUtil(grid, i-1, j);
		countIslandsUtil(grid, i, j+1);
		countIslandsUtil(grid, i, j-1);
		
		return;
		
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}
		};
		
		System.out.println("Number of islands -> " + countIslands(grid));
	}

}
