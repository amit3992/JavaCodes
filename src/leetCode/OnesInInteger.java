package leetCode;

public class OnesInInteger {
	
	public static int getOnes(int n) {
		
		int count = 0;
		while(n > 0) {
			n &= (n-1);
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getOnes(11));

	}

}
