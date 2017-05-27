package leetCode.Arrays;

public class MoveZeros {
	
	public static void moveZeros(int [] array) {
		int n = array.length;
		int count = 0;
		
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(array[i] == 0) {
				count++;
			}
		}
		

		for(int i = 0; i < count; i++) {
			result[i] = 0;
		}
		
		for(int i = 0; i < n; i++) {
			if(array[i] != 0) {
				result[count] = array[i];
				count++;
			}
		}
		
		System.out.println("Result arraay -> ");
		for(int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	

	public static void main(String[] args) {
		
		int [] array = {1, 10, 20, 0, 59, 63, 0, 88, 0};
		
		moveZeros(array);

	}

}
