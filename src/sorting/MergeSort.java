package sorting;

public class MergeSort {
	public boolean isAscending = true;
	public static int[] theArray;
	
	MergeSort(int[] theArray, boolean isAscending) {
		
		this.theArray = theArray;
		this.isAscending = isAscending;
		doMergeSory(this.theArray);
		Util.showArray(this.theArray);
	}
	
	MergeSort(int[] theArray) {
		this.theArray = theArray;
	}

	public void doMergeSory(int[] theArray) {
		
		mergeSort(theArray, new int[theArray.length], 0, theArray.length - 1);
	}

	private void mergeSort(int[] theArray, int[] temp, int leftStart, int rightEnd) {
		
		if(leftStart >= rightEnd) {
			return;
		}
		
		int middle = (rightEnd + leftStart)/2;
		mergeSort(theArray, temp, leftStart, middle);
		mergeSort(theArray, temp, middle+1, rightEnd);
		mergeHalves(theArray, temp, leftStart, rightEnd);
		
	}

	private void mergeHalves(int[] theArray, int[] temp, int leftStart, int rightEnd) {
		
		int leftEnd = rightEnd + leftStart/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(theArray[left] <= theArray[right]) {
				temp[index] = theArray[left];
				left++;
			}
			else {
				temp[right] = theArray[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(theArray, left, temp, index, leftEnd - left + 1);
		System.arraycopy(theArray, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, theArray, leftStart, size);
		
		
	}
	
	public static void main(String[] args) {
		
		int [] array = {1,3,5,4,6,7,2,9,10,8};
		MergeSort ms = new MergeSort(array);
		ms.doMergeSory(array);
		Util.showArray(theArray);
		
	}
}
