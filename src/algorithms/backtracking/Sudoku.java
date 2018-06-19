package algorithms.backtracking;

public class Sudoku {
	
	final int UNASSIGNED = 0;
	
	public boolean SolveSudoku(int [][] grid) {
		
		int row = 0;
		int col = 0;
		
		if(!findUnassigned(grid, row, col)) {
			return true;
		}
		
		for(int num = 1; num <= 9; num++) {
			
			if(isSafe(grid, row, col, num)) {
				grid[row][col] = num;
				
				if(SolveSudoku(grid))
					return true;
				
				grid[row][col] = UNASSIGNED;
			}
		}
		
		return false;
		
	}
	
	private boolean findUnassigned(int [][] grid, int r, int c) {
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == UNASSIGNED) {
					r = row;
					c = col;
					
					return true;
				}
			}
		}
		
		return false;
	}
	private boolean usedInRow(int [][] grid, int row, int value) {
		for(int i = 0; i < grid[row].length; i++) {
			if(grid[row][i] == value) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private boolean usedInCol(int [][] grid, int col, int value) {
		for(int i = 0; i < grid.length; i++) {
			if(grid[i][col] == value) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean usedInBox(int [][] grid, int rowStart, int colStart, int value) {
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(grid[rowStart + r][colStart + c] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	private boolean isSafe(int [][] grid, int row, int col, int num) {
		return !usedInRow(grid, row, num) &&
				!usedInCol(grid, col, num) &&
					!usedInBox(grid, row - row%3, col - col%3, num);
	}
	
	
	public void printGrid(int [][] grid) {
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int N = 9;
		int [][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		Sudoku s = new Sudoku();
		if (s.SolveSudoku(grid) == true)
			s.printGrid(grid);
		else
			System.out.println("No solution exists");

	}

}
