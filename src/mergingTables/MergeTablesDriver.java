package mergingTables;

public class MergeTablesDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeTables djs = new MergeTables();
		
		djs.makeSet(1, 1);
		djs.makeSet(2, 1);
		djs.makeSet(3, 1);
		djs.makeSet(4, 1);
		djs.makeSet(5, 1);
		
		djs.Union(3,5);
		djs.Union(2,4);
		djs.Union(1,4);
		djs.Union(5,4);
		djs.Union(5,3);
		
		djs.numberOfRowsInSet(1);
		djs.numberOfRowsInSet(2);
		djs.numberOfRowsInSet(3);
		djs.numberOfRowsInSet(4);
		djs.numberOfRowsInSet(5);
		

	}

}
