package search;

public class SquareRoot {

    public int getRoot(int num) {

        /* No Square root for negative values */
        if(num <= 1) {
            return num;
        }

        int low = 1;
        int high = num;
        int ans = -1;

        while(low <= high) {

            int mid = low + (high - low)/2;
            //int sqr = mid * mid;

            if(mid <= num/mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }


    public static void main(String [] args) {

        SquareRoot sq = new SquareRoot();

        int root = sq.getRoot(16);
        System.out.println("Square root -> " + root);

    }
}
