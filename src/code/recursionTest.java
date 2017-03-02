package code;

import java.util.ArrayList;

public class recursionTest {
	
	public static void recursionString(ArrayList list, int N) {
		if(list.size() == 1) {
			System.out.println(list.toString());
		}
		else if (list.size() >= N) {
			list.remove(N-1);
			recursionString(list, N);
		}
		else if (list.size() < N) {
			list.remove(N - list.size() - 1);
			recursionString(list, N);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		strList.add("D");
		strList.add("E");
		strList.add("F");
		strList.add("G");
		strList.add("H");
		strList.add("I");
		
		
		recursionString(strList, 3);
	}

}
