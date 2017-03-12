package dataStructures.disjointSets;

public class DisjointSetDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet djs = new DisjointSet();
		
		/*djs.makeSet(1);
		djs.makeSet(2);
		djs.makeSet(3);
		djs.makeSet(4);
		djs.makeSet(5);
		djs.makeSet(6);
		djs.makeSet(7);
		
		
		djs.Union(1,2);
		djs.Union(2,3);
		djs.Union(4,5);
		djs.Union(6,7);
		djs.Union(5,6);
		djs.Union(3,7);
		
		System.out.println(djs.findSet(1));
		System.out.println(djs.findSet(2));
		System.out.println(djs.findSet(3));
		System.out.println(djs.findSet(4));
		System.out.println(djs.findSet(5));
		System.out.println(djs.findSet(6));
		System.out.println(djs.findSet(7)); */
		
		djs.makeSet(1);
		djs.makeSet(2);
		djs.makeSet(3);
		djs.makeSet(4);
		djs.makeSet(5);
		
		djs.Union(3,5);
		djs.Union(2,4);
		djs.Union(1,4);
		djs.Union(5,4);
		djs.Union(5,3);
		
		System.out.println(djs.findSet(1));
		System.out.println(djs.findSet(2));
		System.out.println(djs.findSet(3));
		System.out.println(djs.findSet(4));
		System.out.println(djs.findSet(5));
		
		
		

	}

}
