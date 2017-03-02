package coursera.week2;

import java.util.*;

public class Knapsack {

  static int optimalWeight(int W, int[] w) {
      //write you code here

      int result = 0;
      for (int i = 0; i < w.length; i++) {
        if (result + w[i] <= W) {
          result += w[i];
        }
      }
      return result;
  }

  public static int max(int a, int b) {
  	if(a > b)
  		return a;
  	else
  		return b;
  }

  public static int knapsackWitoutRepetitions(int W, int[] wt) {

  	int nWt = wt.length;
      int value[][] = new int[nWt + 1][W + 1];

		for (int i = 0; i <= nWt; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					value[i][w] = 0;

				else if (wt[i - 1] <= w) {
					//System.out.println("wt["+i+" - 1] = " + wt[i - 1] );
					// System.out.println(K[i-1][w-wt[i-1]]);
					value[i][w] = max(wt[i-1] + value[i - 1][w - wt[i - 1]], value[i - 1][w]);
					//value[i][w] = value[i - 1][w - wt[i - 1]];

				}

				else
					value[i][w] = value[i - 1][w];
			}
		}

		return value[nWt][W];

  }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int W, n;
      W = scanner.nextInt();
      n = scanner.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < n; i++) {
          w[i] = scanner.nextInt();
      }
      //System.out.println(optimalWeight(W, w));
      System.out.println(knapsackWitoutRepetitions(W, w));
  }
}
