package dynamicProgramming;

public class MaxSumSubArray {
	
	public int getMaxSum(int[] array) {
		int[] T = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			T[i] = array[i];
		}
		
		for(int i=1; i < T.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    T[i] = Math.max(T[i], T[j] + array[i]);
                }
            }
        }

        int max = T[0];
        for (int i=1; i < T.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }
        return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxSumSubArray mss = new MaxSumSubArray();
		
		int [] array = {1, 101, 10, 2, 3, 100,4};
		int result = mss.getMaxSum(array);
		
		System.out.println(result);

	}

}
