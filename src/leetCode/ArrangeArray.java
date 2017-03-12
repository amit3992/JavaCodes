package leetCode;

public class ArrangeArray {

	public static int[] rearrangeArray(int[] ar) {
		int len = ar.length;
		int l = 0;
		int h = len - 1;
		int index = 0;
		int[] result = new int[ar.length];
		
		while(l < h && index < len - 1) {
			result[index] = ar[h];
			h--;
			++index;
			result[index] = ar[l];
			++l;
			++index;
		}
		
		return result;
	}
	
	public static void displayArray(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " | ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {9, 99, 999, 9999, 99999, 100000};
		displayArray(rearrangeArray(array));

	}

}
