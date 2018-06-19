package dynamicProgramming;

public class LargestAreaRectangle {

    public static void main(String[] args) {

        /*
        int[][] plots = { {2,1,7},
                {1,1,1},
                {0,3,1},
                {0,2,1}};
        */

        int [][] plots = { {4, 6, 7},
                            {3, 5, 2},
                            {2, 4, 5}

                        };

        int B = 16;
        largestRectangularArea(plots, B);
    }

    static class Cell {
        int leftCol;
        int rightCol;
        int top;
        int bottom;
        int totalPLots;

        Cell(int leftCol, int rightCol, int top, int bottom, int totalPLots) {
            this.leftCol = leftCol;
            this .rightCol = rightCol;
            this.top = top;
            this.bottom = bottom;
            this.totalPLots = totalPLots;
        }

    }
    private static void largestRectangularArea(int[][] plots, int b) {

        int cols = 3;
        int rows = 3;
        int[] longestSubarray = new int[rows];
        int maxPlots = 0;
        Cell maxArea = null;
        Cell area;
        for(int leftCol = 0 ; leftCol < cols; leftCol++) {
            for(int rightCol = leftCol ;rightCol < cols; rightCol++) {
                for(int k = 0 ; k < rows; k++) {
                    longestSubarray[k] = longestSubarray[k] + plots[k][rightCol];
                }
                area = getAreaWithMaxPlots(leftCol,rightCol,longestSubarray, b);

                if(area.totalPLots >= maxPlots) {
                    maxArea = area;
                    maxPlots = area.totalPLots;
                }
            }
        }

        System.out.println("TOP: " + maxArea.top);
        System.out.println("BOTTOM: " + maxArea.bottom);
        System.out.println("LEFT: " + maxArea.leftCol);
        System.out.println("RIGHT: " + maxArea.rightCol);
        System.out.println("TOTAL NUMBER OF PLOTS (cells) in the matrix:" + maxArea.totalPLots);
    }

    private static Cell getAreaWithMaxPlots(int leftCol, int rightCol, int[] arr, int b) {

        int sum = 0;
        int length =0;
        int top = 0;
        int bottom = 0;
        for(int i = 0 ; i < arr.length; i++) {

            if(sum+arr[i] <= b) {
                sum = sum + arr[i];
                length++;
                top = i-length+1;
                bottom = i;
            } else {
                sum = sum + arr[i] - arr[i-length];
            }
        }
        int totalPLots = (rightCol-leftCol+1) * (bottom-top+1);
        Cell cell = new Cell(leftCol, rightCol, top, bottom, totalPLots);
        return cell;
    }
}
