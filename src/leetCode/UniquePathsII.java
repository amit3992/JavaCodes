package leetCode;
import java.util.*;

/*[0,0,0],
  [0,1,0],
  [0,0,0]

Unique paths = 2;
1 - obstacle;
0 - No obstacle
*/

public class UniquePathsII {
	
	public static int getPaths(int[][] grid) {
		int nRows = grid.length;
		int nCols = grid[0].length;
		
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; j++) {
				if(grid[i][j] ==  1) {
					grid[i][j] = 0;
				}
				else if(i == 0 && j == 0) {
					grid[i][j] = 1;
				}
				else if(i == 0) {
					grid[i][j] = grid[i][j-1] * 1;
				}
				else if(j == 0) {
					grid[i][j] = grid[i-1][j] * 1;
				}
				else {
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
				}
			}
		}
		
		return grid[nRows - 1][nCols - 1];
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nRows = sc.nextInt();
		int nCols = sc.nextInt();
		
		int[][] grid = new int[nRows][nCols];
		
		for(int row = 0; row < nRows; row++) {
			for(int col = 0; col < nCols; col++) {
				grid[row][col] = sc.nextInt();
			}
		}
		
		System.out.println("Paths -> " + getPaths(grid));
		sc.close();
	}

}
