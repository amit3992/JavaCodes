package code;
import java.util.*;
public class EratosthenosSieve {
	
	private static ArrayList<Integer> getPrimes(int n) {
		
		boolean [] prime = new boolean[n+1];
		
		for(int i = 0; i < n; i++) {
			prime[i] = true;
		}
		
		for(int p = 2; p*p <= n; p++) {
			
			if(prime[p] == true) {
				
				for(int i = p*2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++) {
			if(prime[i] == true) {
				
				list.add(i);
			}
		}
		
		return list;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int num: getPrimes(40)) {
			System.out.print(num + " ");
		}

	}

}
