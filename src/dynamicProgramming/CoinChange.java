package dynamicProgramming;
import java.util.*;

public class CoinChange {
	
	public static int numberOfWays(int[] dens, int amount) {
		if(amount < 0) {
			return -1;
		}
		
		int[] solution = new int[amount + 1];
		solution[0] = 1;
		
		for(int d: dens) {
			for(int i = d; i <= amount; i++) {
				solution[i] = solution[i] + solution[i - d];
			}
		}
		
		return solution[amount];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] den = {1, 2, 5};
		
		int amount = sc.nextInt();
		
		System.out.println("Number of ways -> " + numberOfWays(den, amount));
		
		

	}

}
