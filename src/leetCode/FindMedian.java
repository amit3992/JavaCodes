package leetCode;
import java.util.*;

public class FindMedian {
	
	public static int getMedian(int[] array1, int[] array2) {
		
		int n1 = array1.length;
		int n2 = array2.length;
		
		if(n1 != n2) {
			System.out.println("Lengths not equal");
			return Integer.MIN_VALUE;
		}
		
		int i = 0;
		int j = 0;
		int m1 = -1;
		int m2 = -1;
		
		for(int index = 0; index <= n1; index++) {
			 
			if (i == n1)
		        {
		            m1 = m2;
		            m2 = array2[0];
		            break;
		        }
		 
		        /*Below is to handle case where all elements of ar2[] are
		          smaller than smallest(or first) element of ar1[]*/
		        else if (j == n1)
		        {
		            m1 = m2;
		            m2 = array1[0];
		            break;
		        }
			if (array1[i] < array2[j])
	        {
	            m1 = m2;  /* Store the prev median */
	            m2 = array1[i];
	            i++;
	        }
	        else
	        {
	            m1 = m2;  /* Store the prev median */
	            m2 = array2[j];
	            j++;
	        }
		}
		
		return (m1 + m2)/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {1, 12, 15, 26, 38};
		int [] array2 = {2, 13, 17, 30, 45};
		
		System.out.println("Median -> " + getMedian(array1, array2));

	}

}
