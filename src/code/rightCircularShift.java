package code;

public class rightCircularShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5};
		int[] newArr = new int[arr.length];
		
		
		newArr = rightCircularShiftArray(arr,2);
		
		for(int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i]);
		}
	}

	private static int[] rightCircularShiftArray(int[] array, int shift) {
		// TODO Auto-generated method stub
		int[] array2 = new int[shift];
		
		for (int i = 0;i < shift;i++) {
			array2[i] = array[array.length - shift + i];
		}
		    
		System.arraycopy(array, 0, array, shift, array.length - shift);
		   
		for (int i = 0; i < shift; i++) {
		    array[i] = array2[i];
		   }
		
		return array;
	}

}
