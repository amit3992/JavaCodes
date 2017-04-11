package leetCode;

/*
 * nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 */
public class MoveZeroes {
	
	public static int[] moveZeros(int[] array) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				array[count] = array[i];
				count++;
			}
		}
		
		while(count < array.length) {
			array[count] = 0;
			count++;
		}
		
		return array;
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,1,0,3,15};
		array = moveZeros(array);
		printArray(array);

	}

}
