package search;

public class FindMin {

    public int findMin(int[] nums) {

        /* Null check */
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {

            /* Case 1 */
            if(nums[low] <= nums[high]) {
                return nums[low];
            }

            /* Calculate mid */
            int mid = low + (high - low) / 2;

            /* Case 2 */
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if(nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return nums[mid];
            }

            /* Case 3 */
            if(nums[mid] <= nums[high]) {
                high = mid - 1;
            }

            /* Case 4 */
            if(nums[mid] >= nums[low]) {
                low = mid + 1;
            }

        }

        return -1;

    }

    public static void main(String [] args) {

        int [] array = {11, 12, 15, 18, 2, 5, 6, 8};

        FindMin fm = new FindMin();

        int minElement = fm.findMin(array);
        System.out.println("The minimum element -> " + minElement);

    }
}
