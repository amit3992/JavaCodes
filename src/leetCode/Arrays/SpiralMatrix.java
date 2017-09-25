package leetCode.Arrays;

public class SpiralMatrix {
	
	public static void spiralPrint(int m, int n, int[][] a) {
		
		if(a == null) {
			return;
		}
		
		if(a.length == 0 || a[0].length == 0) {
			return;
		}
		
		/*
		 * i = iterator
		 * k = starting row index
		 * m = ending row index
		 * 
		 * l = starting column index
		 * n = ending column index
		 * */
		
		int i;
		int k = 0;
		int l = 0;
		
		while(k < m && l < n) {
			
			/* Print the first rows from the remianing rows */ 
			for(i = l; l < n; i++) {
				System.out.print(a[k][l] + " ");
			}
			k++;
			
			/* Print the last column */
			for(i = k; i < m; i++) {
				System.out.print(a[i][n - 1]);
			}
			n--;
			
			if(k < m) {
				
				for (i = n-1; i >= l; --i)
                {
                    System.out.print(a[m-1][i]+" ");
                }
				m--;
			}
			
			if(l < n) {
				
				for (i = m-1; i >= k; --i)
                {
                    System.out.print(a[i][l]+" ");
                }
                l++;  
			}
		}
	}

	public static void main(String[] args) {
		
		 int R = 3;
	     int C = 6;
	     
	     int a[][] = { {1,  2,  3,  4,  5,  6},
	                    {7,  8,  9,  10, 11, 12},
	                    {13, 14, 15, 16, 17, 18}
	                    };
	     
	     spiralPrint(R,C,a);

	}

}
