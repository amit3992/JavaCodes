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

	private static final Scanner scanner = new Scanner(System.in);
	
	private static int coinChange(int [] coins, int sum) {
        
        if(coins == null || coins.length == 0) {
            return 0;
        }
        
        int [] T = new int [sum + 1];
        T[0] = 1;
        
        for(int coin : coins) {
            for(int i = coin; i < (sum + 1); i++) {
                T[i] += T[i - coin];
            }
        }
        
        return T[T.length - 1];
    }


	public static void main(String[] args) {
		
		/*
		Scanner sc = new Scanner(System.in);
		int[] den = {1, 2, 5};
		
		int amount = sc.nextInt();
		
		System.out.println("Number of ways -> " + numberOfWays(den, amount));
		*/
		
		String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] coins = new int[m];

        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int coinsItem = Integer.parseInt(coinsItems[i]);
            coins[i] = coinsItem;
        }
        
        System.out.println(coinChange(coins, n));

        scanner.close();
		

	}

}
