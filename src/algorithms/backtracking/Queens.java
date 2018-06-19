package algorithms.backtracking;
import java.util.*;


public class Queens {

    int GRID_SIZE = 0;

    Queens(int grid) {
        this.GRID_SIZE = grid;
    }


    public void placeQueens(int row, Integer [] columns, List<Integer []> result) {
        if(row == GRID_SIZE) {
            result.add(columns.clone());
        } else {

            for(int col = 0; col < GRID_SIZE; col++) {

                if(checkValid(columns, row, col)) {
                    columns[row] = col; // Place queen
                    placeQueens(row + 1, columns, result);
                }
            }
        }
    }

    private boolean checkValid(Integer [] columns, int row1, int col1) {

        for(int row2 = 0; row2 < row1; row2++) {
            
        	int col2 = columns[row2];

            /* Run checks for validity */

            // If they are on the same column
            if(col2 == col1) {
                return false;
            }

            // If they are on the diagonal
            int colDiff = Math.abs(col2 - col1);
            int rowDiff = row1 - row2;

            if(colDiff == rowDiff) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        Queens q = new Queens(size);
        Integer [] columns = new Integer[size];
        List<Integer []> result = new ArrayList<Integer []>();


        q.placeQueens(0, columns, result);

        System.out.println("Result -> ");
        for(Integer [] cols : result) {
            System.out.println("===========================================");
            for(int r = 0; r < size; r++) {
                System.out.println("Row : " + r + " | Col: " + cols[r]);
            }
        }

    }
}
