package algorithms.backtracking;
import java.util.*;

class Position {
	int row;
	int col;
	
	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class NQueens {
	
	public Position[] solveNQueen(int n) {
		Position[] positions = new Position[n];
		boolean hasSolution = solveNQueenUtil(n, 0, positions);
		if(hasSolution) {
			return positions;
		} else {
			return new Position[0];
		}
	}
	
	private boolean solveNQueenUtil(int n, int row, Position[] positions) {
		
		if(n == row) {
			return true;
		}
		
		int col;
		for(col = 0; col < n; col++) {
			
			boolean foundSafe = true;
			
			/* Check if this row and col is under attack */
			for(int queen = 0; queen < row; queen++) {
				if(positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
						positions[queen].row + positions[queen].col == row + col) {
					foundSafe = false;
					break;
				}
			}
			
			if(foundSafe) {
				positions[row] = new Position(row, col);
				if(solveNQueenUtil(n, row + 1, positions)) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		NQueens nQ = new NQueens();
		Position[] positions = nQ.solveNQueen(4);
		
		for(Position p: positions) {
			System.out.println("Row: " + p.row + " | Col: " + p.col);
		}

	}

}
