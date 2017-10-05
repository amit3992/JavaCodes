package leetCode.Arrays;

public class QuickSort {
	
	public void quickSort(int [] array, int low, int high) {
		
		if(low < high) {
			int pi = partition(array, low, high);
			
			quickSort(array, low, pi-1);
			quickSort(array, pi + 1, high);
		}
	}
	
	public int partition(int [] array, int low, int high) {
		
		int pivot = array[high];
		
		int loIndex = low;
		
		for(int j = low; j < high; j++) {
			
			if(array[j] <= pivot) {
				
				swap(array, loIndex, j);
				loIndex++;
			}
		}
		
		// swap arr[i+1] and arr[high] (or pivot)
		swap(array, loIndex, high);
       
        return loIndex;
	}
	
	private void swap(int [] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	public static void main(String[] args) {
		
		int [] arr = {1,4,5,6,8,10,3,2,9,7};
		int low = 0;
		int high = arr.length - 1;
		
		QuickSort qs = new QuickSort();
		qs.quickSort(arr, low, high);
		qs.printArray(arr);

	}

}
