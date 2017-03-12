package DSA;

//Based on Derek Banas's lecutres

public class ArrayStructure {

	private static int[] theArray = new int[50];

	public static int arraySize = 10;

	public static void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) ((Math.random()*10)+10);
		}
	}

	public void showArray() {
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++) {
			System.out.println("| "+ i +" | " + theArray[i] + " |");
			System.out.println("----------");
		}
	}


	public int returnValueAt(int pos) {
		return theArray[pos];
	}

	public static boolean doesArrayContain(int value) {
		// O(n)
		boolean flag = false;

		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value)
				flag = true;
		}

		return flag;
	}

	public void deleteValueAtIndex(int index) {

		if(index < arraySize) {

			for(int i = index; i < arraySize - 1; i++) {
				theArray[i] = theArray[i+1];
			}

		}

		arraySize--;
	}

	public void insertValueAtEnd(int value) {
		 if(arraySize < 50) {
			 theArray[arraySize] = value;
			 arraySize++;
		 }
	}

	public String linearSearchForValue(int value) {

		// Linear search better to return ALL our mathches
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value)
				sb.append(i+" ");
		}

		return sb.toString();
	}

	public void bubbleSortArray(boolean inAscending) {

		System.out.println("-------- Bubble Sort --------");

		if(inAscending) {
			// Sort in Ascending
			for(int i = arraySize - 1; i > 1; i--) {

				for(int j = 0; j < i; j++) {
					if(theArray[j] > theArray[j+1]) {
						swapArrayValues(j, j+1);
					}
				}
			}
		}
		else {
				// Sort in descending
				for(int i = arraySize-1; i > 1; i--) {

				for(int j = 0; j < i; j++) {
					if(theArray[j] < theArray[j+1]) {
						swapArrayValues(j, j+1);
					}
				}
			}
		}


	}

	public void binarySearch(int value) {
		// Wroks only if array is sorted.

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		while(lowIndex <= highIndex) {

			int middleIndex = (lowIndex + highIndex)/2;

			if(theArray[middleIndex] > value)
				highIndex = middleIndex - 1;
			else if(theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;
			else {
				System.out.println("Found! Value is at index: "+middleIndex);
				lowIndex = highIndex + 1;
			}
		}
	}

	public void selectionSort(boolean isAscending) {

		System.out.println("--------- Selection Sort --------");

		if(isAscending) {

			// Selection sort for Ascending order
			for(int i = 0; i < arraySize; i++) {

				int min = i;

				for(int j = i; j < arraySize; j++) {

					if(theArray[min] > theArray[j])
						min = j;
				}

				swapArrayValues(i, min);
			}
		}
		else {
			// Selection sort for descending order
			for(int i = 0; i < arraySize; i++) {

				int min = i;

				for(int j = i; j < arraySize; j++) {

					if(theArray[min] < theArray[j])
						min = j;
				}

				swapArrayValues(i, min);
			}

		}


	}

	public void insertionSort() {

		for(int i = 1; i < arraySize; i++) {
			int j = i;

			int toInsert = theArray[i];

			while((j > 0) && (theArray[j-1] > toInsert)) {

				theArray[j] = theArray[j-1];
				j--;
			}
			theArray[j] = toInsert;

			System.out.println("theArray["+i+"] = " + theArray[i] + " theArray["+j+"] = " + theArray[j]+" toInser = "+toInsert);
		}
	}

	private void swapArrayValues(int i, int j) {
		// TODO Auto-generated method stub
		int temp = theArray[j];
		theArray[j] = theArray[i];
		theArray[i] = temp;

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayStructure NewArray = new ArrayStructure();

		NewArray.generateRandomArray();
		NewArray.showArray();
		//System.out.println(NewArray.returnValueAt(4));
		//NewArray.deleteValueAtIndex(4);
		//NewArray.insertValueAtEnd(55);
		//NewArray.printArrayHorizontally();
		//System.out.println(NewArray.linearSearchForValue(13));

		//NewArray.bubbleSortArray(true);
		//NewArray.showArray();
		//NewArray.binarySearch(15);

		//NewArray.selectionSort(false);
		//NewArray.showArray();

		NewArray.insertionSort();
		System.out.println(" ----------------- SORTED ARRAY -----------------");
		NewArray.showArray();

	}

}
