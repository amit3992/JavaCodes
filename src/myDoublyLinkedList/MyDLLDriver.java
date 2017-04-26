package myDoublyLinkedList;

public class MyDLLDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyDLList<String> dll = new MyDLList<String>();
		
		dll.addFirst("Amit");
		dll.addLast("Alida");
		dll.addLast("Uptown");
		dll.addFirst("ABC");
		
		dll.iterateForward();
	}

}
