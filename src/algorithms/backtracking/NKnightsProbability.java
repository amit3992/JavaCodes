package algorithms.backtracking;

import java.util.Arrays;

public class NKnightsProbability {
	
	private boolean isLegal(int row, int col, int size) {
		return (row > 0) && (row <= size) && (col > 0) && (col <= size);
	}
	
	private final int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
	
	public double nKnightProb(int N, int k, int r, int c) {
		
		int size = N;
		double[][] T = new double[N][N];
		
		for(double[] row : T) 
			Arrays.fill(row, 1);
		
		for(int q = 0; q < k; q++) {
			
			double[][] T1 = new double[size][size];
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					
					for(int[] move: moves) {
						int row = i + move[0];
						int col = j + move[1];
						
						if(isLegal(row, col, size)) {
							T1[i][j] += T[row][col]; 
						}
					}
				}
			}
			
			T = T1;
		}
		
		return T[r][c]/Math.pow(8, k);
	}

	public static void main(String[] args) {
		
		NKnightsProbability knp = new NKnightsProbability();
		System.out.println("Knight probability: " + knp.nKnightProb(8, 2, 0, 0));
		

	}

}
