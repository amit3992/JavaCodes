package leetCode;
import java.util.*;


public class Pascal {
	
	public static ArrayList<Integer> generatePascalUtil(ArrayList<Integer> arr) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int first = arr.get(0);
		int last = arr.get(arr.size() - 1);
		array.add(first);
		for(int i = 1; i < arr.size(); i++) {
			int sum = arr.get(i) + arr.get(i - 1);
			array.add(sum);
		}
		array.add(last);
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		generatePascal(n);

	}

	private static void generatePascal(int n) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		
		first.add(1);
		second.add(1);
		second.add(2);
		second.add(1);
		newList = second;
		
		for(int i = 1; i <= n; i++) {
				if(i == 1) {
					list.add(first);
				}
				if(i == 2) {
					list.add(second);
				}
				else if (i > 2) {
					newList = generatePascalUtil(newList);
					list.add(newList);
				}
		}
		

		for(ArrayList<Integer> aList : list ) {
			System.out.println(aList.toString());
		}
		
	}

}
