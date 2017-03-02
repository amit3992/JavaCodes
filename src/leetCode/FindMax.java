package leetCode;

public class FindMax {
	
	public static int findMax(int[] arr) {
		int n = arr.length;
		return findMaxUtil(arr, 0, n - 1);
	}
	
	public static int findMaxUtil(int[] arr, int low, int high) {
		
		//Base case i.e only one elements in array
		if(low == high)
			return arr[low];
		
		/* If there are two elements and first is greater then
	      the first element is maximum */
	   if ((high == low + 1) && arr[low] >= arr[high])
	      return arr[low];
	   
	   // 3rd case
	   if ((high == low + 1) && arr[low] < arr[high])
		      return arr[high];
	   
	   int mid = (low + high)/2;
	   
	   if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
		   return arr[mid];
	   
	   /* If arr[mid] is greater than the next element and smaller than the previous 
	    element then maximum lies on left side of mid */
	   if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
	     return findMaxUtil(arr, low, mid-1);
	   else // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
	     return findMaxUtil(arr, mid + 1, high);
	   
	   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 50, 60,10, 9, 7, 6};
		System.out.println(findMax(arr));

	}

}
