package algorithms.backtracking;
import java.util.*;

public class WordSearch {
	int row;
	int col;
	
	public boolean searchWord(char[][] grid, String word) {
		
		row = grid.length;
		col = grid[0].length;
		
		if(row == 0) {
			return false;
		}
		char[] words = word.toCharArray();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(exists(grid, i, j, words, 0)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean exists(char[][] grid, int x, int y, char[] words, int index) {
		if(index == words.length) {
			return true;
		}
		
		if(x < 0 || x >= row || y < 0 || y >= col) {
			return false;
		}
		
		if(grid[x][y] != words[index]) {
			return false;
		}
		
		grid[x][y] ^= 256;
		
		boolean exists = exists(grid, x+1, y, words, index+1)
				|| exists(grid, x-1, y, words, index+1)
				|| exists(grid, x, y+1, words, index+1)
				|| exists(grid, x, y-1, words, index+1);
		
		grid[x][y] ^= 256;
		
		return exists;
	}

	public static void main(String[] args) {
		
		char[][] grid = {{'A','B','C','E'}, 
						{'S','F','C','S'}, 
						{'A','D','E','E'}};
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		WordSearch ws = new WordSearch();
		
		System.out.println(word + " exists -> " + ws.searchWord(grid, word));
	}

}
