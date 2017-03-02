package coursera.divideAndconquer;
import java.util.*;


public class PolynomialMultiplication {
	
	private static int[] naivePolyMultiplication(int[] inputA, int[] inputB) {
		
		/*
		 * Complexity: O(n^2)
		 */
		
		int n = inputA.length;
		int [] product = new int[2*n - 1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				product[i + j] = product[i + j] + (inputA[i] * inputB[j]);
			}
		}
		
		return product;
	}
	
	private static void showArray(int[] input) {
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i] + " (" + (input.length - 1 -i) + ")");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {-1, 1, 3, 5, 2};
		int[] B = {6, 3, 2, 2, 1};
		
		int[] product = naivePolyMultiplication(A, B);
		showArray(product);

	}

}
