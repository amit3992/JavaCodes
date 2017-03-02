package code;
import java.util.*;


public class HarmonicSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		double sumL2R = 0.0;
		double sumR2L = 0.0;
		
		for(int ind = 1; ind <= n; ind++) {
			sumL2R = sumL2R + (1/ind);
		}
		
		for(int i = n; i > 0; i--) {
			sumR2L = sumR2L + (1/i);
		}
		
		if(sumL2R > sumR2L) {
			double delta = sumL2R - sumR2L;
			System.out.println("Diff: "+delta);
		} else if (sumR2L > sumL2R) {
			double delta = sumR2L - sumL2R;
			System.out.println("Diff: "+delta);
		} else if (sumL2R == sumR2L) {
			System.out.println("Diff: 0");
		}
		
		System.out.println(4%2);

	}

}
