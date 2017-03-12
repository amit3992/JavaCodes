package dataStructures.UnrolledLL;

public class UnrolledLLDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUnrolledLL ull = new MyUnrolledLL();
		
		ull.addDataToNodePosition(0,1);
		ull.addDataToNodePosition(0,2);
		ull.addDataToNodePosition(0,3);
		ull.addDataToNodePosition(0,4);
		ull.addDataToNodePosition(0,5);
		
		ull.createNewNodeAt(1, 'B');
		ull.addDataToNodePosition(1, 10);
		ull.addDataToNodePosition(1, 20);
		ull.addDataToNodePosition(1, 30);
		ull.addDataToNodePosition(1, 40);
		ull.addDataToNodePosition(1, 50);
		
		ull.createNewNodeAt(1, 'C');
		ull.addDataToNodePosition(1, 10);
		ull.addDataToNodePosition(1, 20);
		ull.addDataToNodePosition(1, 30);
		ull.addDataToNodePosition(1, 40);
		ull.addDataToNodePosition(1, 50);
		
		
		
	}

}
