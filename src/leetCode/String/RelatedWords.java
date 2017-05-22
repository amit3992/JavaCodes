package leetCode.String;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
/*Link: https://www.hiredintech.com/classrooms/algorithm-design/lesson/27/task/19*/

/*It is a nice day today, the sun is shining. However, the weather is expected to get worse the following few days. Nice day by day weather forecasts can be found literally everywhere on the “Internet”. So, it is quite easy to know what to expect tomorrow.*/

public class RelatedWords {
	
	HashMap<String, Integer> wordMap;
	
	public String getRelatedWord(String sentence, String word, int n) {
		
		if(sentence == null || sentence.isEmpty()) {
			return new String();
		}
		
		String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		wordMap = new HashMap<String, Integer>();
		int len = words.length;
		
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word)) {
				addWordsToMap(words, word, i, n, len);
			}
		}
	}
	
	public void addWordsToMap(String[] words, String word, int loc, int n, int len) {
		
		int start = loc - n;
		int end = loc + n;
		
		i
		for(int i = start; i <= end; i++) {
			
			if(i < 0 || i >= len) {
				continue;
			} else {
				if(!words[i].equals(word)) {
					
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		String word = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("Related word in given sentence -> " + getRelatedWord(sentence, word, n));

	}

}
