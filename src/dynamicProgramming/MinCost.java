package dynamicProgramming;

public class MinCost {
	
	public static int minCost(int[][] cost, int m, int n) {
		int[][] grid = new int[m+1][n+1];
		
		grid[0][0] = cost[0][0];
		
		// Initialize first column;
		for(int i = 1; i <= m; i++) {
			grid[i][0] = grid[i-1][0] + cost[i][0];
		}
		
		// Initialize first column;
		for(int j = 1; j <= n; j++) {
			grid[0][j] = grid[0][j-1] + cost[0][j];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				grid[i][j] = min(grid[i-1][j-1], grid[i-1][j], grid[i][j-1]) + cost[i][j];
			}
		}
		
		return grid[m][n];
	}
	
	/* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

	public static void main(String[] args) {
		
		int cost[][]= { {1, 2, 3},
						{4, 8, 2},
						{1, 5, 3}};
		
		System.out.println("minimum cost to reach (2,2) = " + minCost(cost,2,1));

	}

}
