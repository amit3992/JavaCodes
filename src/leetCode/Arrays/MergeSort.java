package leetCode.Arrays;

public class MergeSort {
	
	public void merge(int[] array, int l, int m, int r) {
		
		/* Find sizes of the two sub-arrays to be merged */
		int n1 = m - l + 1;
		int n2 = r - m;
		
		/* Create helper arrays */
		int [] L = new int[n1];
		int [] R = new int[n2];
		
		/* Copy data to temporary arrays */
		for(int i = 0; i < n1; i++) {
			L[i] = array[l + i];
		}
		
		for(int j = 0; j < n2; j++) {
			R[j] = array[m + 1 + j];
		}
		
		/* Merge temporary arrays */
		// Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        
        while(i < n1 && j < n2) {
        	if(L[i] < R[j]) {
        		array[k] = L[i];
        		i++;
        	} else {
        		array[k] = R[j];
        		j++;
        	}
        	
        	k++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            array[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            array[k] = R[j];
            j++;
            k++;
        }
		
		
	}
	
	public void mergeSort(int[] array, int l, int r) {
		int m = 0;
		
		if(r > l) {
			
			m = l + (r - l)/2;
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			
			merge(array, l, m, r);
			
		}
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
		
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, low, high);
		ms.printArray(arr);
		
	}

}
