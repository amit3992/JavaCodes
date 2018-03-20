package dynamicProgramming;

public class ArrayProductExceptSelf {
	
	public int[] getModifiedArray(int [] nums) {
		
		int n = nums.length;
		int [] res = new int[n];
		
		res[0] = 1;
		
		for(int i = 1; i < n; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		
		int right = 1;
		
		for(int i = n-1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,2,3,4};
		ArrayProductExceptSelf ap = new ArrayProductExceptSelf();
		arr = ap.getModifiedArray(arr);
		
		System.out.println("Solution");
		for(Integer i : arr) {
			System.out.print(i + " ");
		}

	}

}
