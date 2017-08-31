package search;

public class UbiquitousBSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {2,3,4,5,6,7, 7, 7, 7 , 8, 8,11,14,16};
		
		int [] rotatedArray = {6, 7, 8, 9, 10, 1 ,2, 3, 4, 5};
		
		UbiquitousBinarySearch ubs1 = new UbiquitousBinarySearch(rotatedArray);
		
		int high = array.length - 1;
		int size = rotatedArray.length;
		
		UbiquitousBinarySearch ubs = new UbiquitousBinarySearch(array);
		
		System.out.println("Val 8 is at index: " + ubs.basicBinarySearch(8, high, 0));
		System.out.println("Floor of 9 is: " + ubs.floorBinarySearch(9, high));
		System.out.println("Number of occurrences of 7 is: " + ubs.countOccurrences(7, high));
		System.out.println("Search for min element in sorted rotated array: " + ubs1.minElementInRotatedArray(size));
		
		System.out.println("Search for element in rotated sorted array: " + ubs1.searchRotatedSorted(10, size));

	}

}
