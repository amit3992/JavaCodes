package leetCode.graph;

/* LC #200 */

public class NumberOfIslands {
	
public int numIslands(char[][] grid) {
        
        int count = 0;
        int n = grid.length;
        
        if(n == 0) {
            return 0;
        }
        
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfsUtil(i, j, grid);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfsUtil(int i, int j, char[][] grid) {
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = '0';
        dfsUtil(i + 1, j, grid);
        dfsUtil(i - 1, j, grid);
        dfsUtil(i, j + 1, grid);
        dfsUtil(i, j - 1, grid);
    }

}
