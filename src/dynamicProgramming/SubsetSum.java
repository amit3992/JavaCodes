package dynamicProgramming;

public class SubsetSum {
	
	public boolean getSum(int[] array, int key) {
		
		boolean T[][] = new boolean [array.length + 1][key + 1];
		for(int i = 0; i <= array.length; i++) {
			T[i][0] = true;
		}
		
		for(int i = 1; i <= array.length; i++) {
			for(int j = 1; j <= key; j++) {
				if(j - array[i-1] >= 0) {
					T[i][j] = T[i-1][j] || T[i-1][j - array[i-1]];
				}
				else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[array.length][key];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubsetSum ss = new SubsetSum();
		
		int [] array = {1, 101, 10, 2, 3, 100,4};
		
		boolean result = ss.getSum(array, 30);
		
		System.out.println(result);

	}


}
