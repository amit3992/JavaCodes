package leetCode.String;
import java.util.*;

public class WordLadder {
	
	private static LinkedList<String> transform(String beginWord, String endWord, HashSet<String> wordDict) {
		
		HashSet<String> visited = new HashSet<String>();
		
		return transform(visited, beginWord, endWord, wordDict);
	}
	
	private static LinkedList<String> transform(HashSet<String> visited, String start, String end, HashSet<String> wordDict) {
		
		if(start.equals(end)) {
			LinkedList<String> path = new LinkedList<String>();
			path.add(end);
			return path;
		}
		else if(visited.contains(start) || !wordDict.contains(start)){
			return null;
		}
		
		visited.add(start);
		ArrayList<String> words = wordsOneAway(start);
		
		for(String word: words) {
			LinkedList<String> path = transform(visited, word, end, wordDict);
			
			if(path != null) {
				path.addFirst(start);
				return path;
			}
		}
		
		return null;
	}
	
	private static ArrayList<String> wordsOneAway(String word) {
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < word.length(); i++) {
			for(char c = 'a'; c <= 'z'; c++) {
				String w = word.substring(0, i) + c + word.substring(i + 1);
				words.add(w);
			}
		}
		
		return words;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
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
