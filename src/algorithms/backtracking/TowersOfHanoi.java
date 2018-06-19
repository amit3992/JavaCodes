package algorithms.backtracking;

public class TowersOfHanoi {
	
	public void towerOfHanoi(int n, char from, char to, char buffer) {
		if(n == 1) {
			System.out.println("Move disk 1 from rod -> " + from + " to rod -> " + to);
			return;
		}
		
		towerOfHanoi(n - 1, from, buffer, to);
		System.out.println("Move disk " + n + " from rod -> " + from + " to rod -> " + to);
		towerOfHanoi(n - 1, buffer, to, from);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		TowersOfHanoi th = new TowersOfHanoi();
		th.towerOfHanoi(n, 'A', 'C', 'B');

	}

}
