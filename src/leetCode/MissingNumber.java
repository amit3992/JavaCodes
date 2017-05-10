package leetCode;

public class MissingNumber {
	
	public static int getMissingNumber(int[] a, int n) {
		int i = n-1;
		
		while(i > 0) {
			n  ^= i ^ a[i];
			i--;
		}
		
		return n;
	}

	public static void main(String[] args) {
		int[] array = {0, 2, 1, 3, 4, 9, 7, 5, 6};
		int n = array.length;
		System.out.println("Missing number -> " + getMissingNumber(array, n));

	}

}
