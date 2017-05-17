package leetCode.graph;
import java.util.*;


public class RatMaze {
	int N;
	
	public void solveMaze(int[][] maze) {
		
			N = maze.length;
		
			int [][] sol = {{0,0,0,0}, 
							{0,0,0,0}, 
							{0,0,0,0}, 
						{0,0,0,0}};
			
			if(solveMazeUtil(maze, 0, 0, sol) == false) {
				System.out.println("No solution exists!");
			} else {
				System.out.println(" Solution: ");
				printSolution(sol);
			}
	}
	
	public boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		
		if(x == N-1 && y == N-1) {
			sol[x][y] = 1;
			return true;
		}
		
		/*check if x and y is valid*/
		if(isSafe(maze, x, y)) {
			
			/*Mark x and y a part of solution*/
			sol[x][y] = 1;
			
			/*Move in forward direction*/
			if(solveMazeUtil(maze, x, y+1, sol)) {
				return true;
			}
			
			/*Move in forward y direction*/
			if(solveMazeUtil(maze, x+1, y, sol)) {
				return true;
			}
			
			/*If none work, back track and mark sol[x][y] == 0*/
			sol[x][y] = 0;
			return false;
		}
		
		return false;
	}

	
	
	/*Util methods*/
	
	public void printSolution(int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				System.out.print(" " + grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isSafe(int[][] grid, int x, int y) {
		if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		
		RatMaze rat = new RatMaze();
		
		int[][] maze = {{1, 0, 0, 0}, 
						{1, 1, 1, 1}, 
						{1, 0, 0, 0}, 
						{1, 1, 1, 1}};
		
		rat.solveMaze(maze);
	}

}
