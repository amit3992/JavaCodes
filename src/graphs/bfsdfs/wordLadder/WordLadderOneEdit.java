package graphs.bfsdfs.wordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderOneEdit {
	
	private static LinkedList<String> transform(String start, String end, HashSet<String> wordDict) {
		HashSet<String> visited = new HashSet<String>();
		
		LinkedList<String> path = new LinkedList<String>();
		path.add(start);
		
		transformUtil(visited, start, end, wordDict, path);
		
		return path;
	}
	
	private static void transformUtil(HashSet<String> visited, String start, String end, HashSet<String> wordDict, LinkedList<String> path) {
		
		if(start.equals(end)) {
			return;
		}
		else if(visited.contains(start) || !wordDict.contains(start)) {
			return;
		}
		
		visited.add(start);
		
		String word = wordOneAway(start, wordDict, visited);
		path.add(word);
		
		transformUtil(visited, word, end, wordDict, path);
		
		
	}
	
	private static String wordOneAway(String word, HashSet<String> wordDict, HashSet<String> visited) {
		
		MinEditDistance ed = new MinEditDistance();
		ArrayList<String> words = new ArrayList<String>();
		for(String s: wordDict) {
			
			int editDist = ed.minEditDistance(word, s);
			if(editDist == 1 && !visited.contains(s)) {
				return s;
			}
		}
		
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> wordDict = new HashSet<String>();
		wordDict.add("hit");
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		wordDict.add("cog");
		
		LinkedList<String> path = transform("hit", "cog", wordDict);
		
		while(path != null && !path.isEmpty()) {
			System.out.print(path.remove() + "->");
		}

	}

}
