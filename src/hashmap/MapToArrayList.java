package hashmap;
import java.util.*;
import java.util.Map.Entry;

public class MapToArrayList {
	
	public static HashMap<String, Integer> createMap() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return map;
	}
	
	private static void convertMapToListAndDisplay(HashMap<String, Integer> map) {
		
		System.out.println("Size of map: " + map.size());
		Iterator it = map.entrySet().iterator();
		System.out.println("Contents of map:");
		while(it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " -> " + pairs.getValue());
		}
		
		// Converting HashMap keys into ArrayList
				List<String> keyList = new ArrayList<String>(map.keySet());
				System.out.println("\n==> Size of Key list: " + keyList.size());
		 
				for (String temp : keyList) {
					System.out.println(temp);
				}
		 
				// Converting HashMap Values into ArrayList
				List<Integer> valueList = new ArrayList<Integer>(map.values());
				System.out.println("\n==> Size of Value list: " + valueList.size());
				for (Integer temp : valueList) {
					System.out.println(temp);
				}
		 
				List<Entry> entryList = new ArrayList<Entry>(map.entrySet());
				System.out.println("\n==> Size of Entry list: " + entryList.size());
				for (Entry temp : entryList) {
					System.out.println(temp);
				}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = createMap();
		map.put("eBay", 4444);
		map.put("Yahoo", 1234);
		map.put("Google", 5555);
		map.put("Qualtrics", 100);
		
		convertMapToListAndDisplay(map);

	}

}
