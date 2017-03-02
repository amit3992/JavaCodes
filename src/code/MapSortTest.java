package code;

import java.util.*;

/** Sorting Strings in Unicode order. */
public final class MapSortTest {

  public static void main(String... aArgs){
    List<String> insects = Arrays.asList("Wasp", "ant", "", "Bee");
    log("Original:");
    log(insects);
    log("Sorted:");
    sortList(insects);
    log(insects);
    log("");

    Map<String,String> capitals = new LinkedHashMap<>();
    capitals.put("finland", "Helsinki");
    capitals.put("United States", "Washington");
    capitals.put("Mongolia", "Ulan Bator");
    capitals.put("Canada", "Ottawa");
    log("Original:");
    log(capitals);
    log("Sorted:");
    log(sortMapByKey(capitals));
    
    HashMap<Integer, Integer> intMap = new HashMap<Integer,Integer>();
    intMap.put(6, 6);
    intMap.put(5, 10);
    intMap.put(2, 8);
    intMap.put(4, 1);
    intMap.put(1, 1);
    
  }

  private static void sortList(List<String> aItems){
    Collections.sort(aItems, String.CASE_INSENSITIVE_ORDER);
  }

  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject)); 
  }

  private static Map<String, String> sortMapByKey(Map<String, String> aItems){
    TreeMap<String, String> result = 
      new TreeMap<>(String.CASE_INSENSITIVE_ORDER)
    ;
    result.putAll(aItems);
    return result;
  }
} 
