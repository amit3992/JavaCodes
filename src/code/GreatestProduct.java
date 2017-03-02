/*
 * Problem Statement: 2,2,3,5,4,1 --> Input
 * Output --> 5
 * 
 */
package code;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class GreatestProduct {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		line = in.readLine();
		line = line.trim();
		// Read the inputs into a list
		ArrayList<Integer> valList = new ArrayList<Integer>();
		ArrayList<Integer> uniqueValList = new ArrayList<Integer>();
		for(String retVal: line.split(",")) {
			int val = Integer.parseInt(retVal);
			valList.add(val);
		}
		
		uniqueValList = removeDuplicates(valList);
		HashMap<Integer,Integer> valMap = new HashMap<Integer,Integer>();
		
		for(int i : uniqueValList) {
			int count = Collections.frequency(valList,i);
			int prod = i*count;
			valMap.put(i, prod);
		
		}
		
		getLargestVal(valMap);
		
	}

	private static void getLargestVal(HashMap<Integer, Integer> valMap) {
		// TODO Auto-generated method stub
		int maxValue = (Collections.max(valMap.values()));
		
		for (Entry<Integer, Integer> entry : valMap.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println(entry.getKey());
            }
        }
		
	}

	private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> valList) {
		
		// TODO Auto-generated method stub
		Set<Integer> noDups = new HashSet<Integer>();
		noDups.addAll(valList);
		return new ArrayList<Integer>(noDups);
	}

}
