package code;
import java.util.*;

public class RepeatingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<String> cl = new ArrayList<String>();
		HashMap<Integer,String> hMap = new HashMap<Integer,String>();
		
		al.add(1);
		al.add(1);
		al.add(2);
		al.add(2);
		al.add(3);
		al.add(3);
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(6);
		
		cl.add("amit");
		cl.add("amita");
		cl.add("ben");
		cl.add("ben");
		cl.add("caren");
		cl.add("caren");
		cl.add("caren");
		cl.add("caren");
		cl.add("dominic");
		cl.add("dominic");
		
		
		// Print the name from the list....
		int val = 1;
        for(int i : al) {
            val = val^al.get(i);
        }
        
        for(String s : cl) {
        	hMap.put(s.hashCode(), s);
        }
        
        System.out.println(hMap.size());

       // ForEach only for Java 8
       hMap.forEach((key, value) -> System.out.println(value + " : " + key));
        
    
		
		
	}

}
