package leetCode.Arrays;

public class CircularArrayLoop {
	
	public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }
    
    public int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {2, -1, 1, 2, 2};
		int [] array2 = {1, 2};
		
		CircularArrayLoop cal = new CircularArrayLoop();
		System.out.println("Contains loop? -> " + cal.circularArrayLoop(array1));

	}

}
