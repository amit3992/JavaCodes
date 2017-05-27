package leetCode.Arrays;
import java.util.*;

public class PascalTriangle {
	
	public static void getPascalTriangle(int n) {
		
		if(n == 0 || n < 0) {
			System.out.println("Invalid input!");
			return;
		}
		
		for(int line = 1; line <= n; line++) {
			int C = 1;
			for(int i = 1; i <= line; i++) {
				System.out.print(C + " ");
				C = C * (line - i)/i;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		getPascalTriangle(n);

	}

}
