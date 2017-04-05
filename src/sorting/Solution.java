package sorting;

import java.io.*;
import java.util.*;

public class Solution {
    
    int[] array;
    //int count = 0;
    
    Solution(int[] array) {
        this.array = array;
    }
   
    public void doQuickSort() {
        
        quickSort(this.array, 0, this.array.length - 1);
    }
    
    private void quickSort(int[] array, int left, int right) {
        
        if(left >= right) {
            return;
        }
        
       
        int index = partition(array, left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
        
//        printSubArray(array, left, right);
        
    }
    
    private int partition(int[] array, int left, int right) {
    	int pivot = array[right];
    	System.out.println("Pivot -> " + pivot);
        while(left < right) {
            
            while(array[left] < pivot) {
                left++;
            }
            
            while(array[right] > pivot) {
                right--;
            }
            
            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        
        return left;
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void printArray() {
        for(int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
    
    public void printSubArray(int[] subArray, int s, int e) {
        for(int i = s; i <= e; i++) {
            System.out.print(subArray[i] + " ");
        }
        System.out.println();
    }
    

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();
        int n = Integer.parseInt(line);
        
        int[] array = new int[n];
        
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        int i = 0;
        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            array[i] = val;
            i++;
        }
        
        Solution s = new Solution(array);
        s.doQuickSort();
        s.printArray();
        
       
    }
}