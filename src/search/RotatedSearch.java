package search;

public class RotatedSearch {

    private int searchUtil(int [] input, int start, int end, int target) {

        if(start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if(input[mid] == target) {
            return mid;
        }

        /* Search left */
        if(input[start] < input[mid] && target >= input[start] && target < input[mid]) {
            return searchUtil(input, start, mid - 1, target);
        }

        /* Search right */
        if(input[end] > input[mid] && target <= input[end] && target > input[mid]) {
            return searchUtil(input, mid + 1, end, target);
        }

        /* Search left again */
        if(input[start] > input[mid]) {
            return searchUtil(input, start, mid - 1, target);
        }

        if(input[end] < input[mid]) {
            return searchUtil(input, mid + 1, end, target);
        }

        return -1;
    }

    public int searchElement(int [] input, int target) {

        /* Null check */
        if(input == null || input.length == 0) {
            return -1;
        }

        int n = input.length - 1;

        return searchUtil(input, 0, n, target);
    }

    public static void main(String [] args) {

        int [] array = {11, 12, 15, 18, 2, 5, 6, 8};

        RotatedSearch rs = new RotatedSearch();

        int index = rs.searchElement(array, 18);
        System.out.println("The index of element -> " + index);

    }
}
