package leetCode;
import java.util.*;

public class ArrangeCoins {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int val = arrangeCoins(n,n);
		System.out.println(val);

	}

	private static int arrangeCoins(int n, int input) {
		// TODO Auto-generated method stub
		int count = 0;
		int countFull = 0;
		boolean doBreak = false;
		for(int i = 1; i <= n; i++) {
			int rowCount = 0;
			for(int j = 0; j < i; j++) {
				//System.out.print("*");
				count++;
				rowCount++;
				if(count == input){
					doBreak = true;
					break;
				}
			}
			if(rowCount == i) {
				countFull++;
			}
			if(doBreak) break;
			//System.out.println();
		}
		return countFull;
	}
	
	

}
