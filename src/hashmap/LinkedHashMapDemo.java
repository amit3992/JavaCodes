package hashmap;
import java.util.*;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
		
		map.put("Manchester United", new Double(69.69));
		map.put("Arsenal", new Double(70.12));
		map.put("Manchester City", new Double(73.69));
		map.put("Liverpool", new Double(77.79));
		map.put("Chelsea", new Double(83.69));
		
		Set set = map.entrySet();
		
		Iterator i = set.iterator();
		
		
		
		Double add = new Double(10.11);
		Double pts = map.get("Manchester United").doubleValue();
		
		map.put("Manchester United", new Double(pts + add));
		
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + " : " + me.getValue());
			System.out.println();
		}

	}

}
