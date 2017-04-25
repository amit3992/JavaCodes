package sorting;

public class CountingSortTest {
	
	public static void countingSort(int[] a, int k) {
		int [] c = new int[k];
		
		for(int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}
		
		for(int i = 1; i < k; i++) {
			c[i] += c[i-1];
		}
		
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			b[-- c[a[i]]] = a[i];
		}
		
		System.out.println("SORTED ARRAY");
		for(int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {5,6,7,3,2,0,1,10,8,9,4};
		int[] array2 = {1,6,7,3,2,1,1,10,8,9,4};
		
		countingSort(array1, 11);
		countingSort(array2, 11);

	}

}
