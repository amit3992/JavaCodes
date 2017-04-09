package leetCode;
import java.util.*;
import java.io.*;

/*
 * ip: ABDEFGABEF
 * op: 6 -> BDEFGA
 */

public class LongestUniqueSubstring {
	
	private static int min(int a, int b) {
		return (a > b) ? a: b;
	}
	
	public static int getLongestUniqueSubstring(String s) {
		
		int n = s.length();
		int cur_len = 1; // Length of current substring;
		int max_len = 1; // Length of longest substring;
		int prev_index;
		int[] visited = new int[256];
		
		// Initialize visited array to -1
		for(int i = 0; i < 256; i++) {
			visited[i] = -1;
		}
		
		// Mark first char as visited
		visited[(int)s.charAt(0)] = 0;
		
		for(int i = 1; i < n; i++) {
			prev_index = visited[(int)s.charAt(i)];
			
			if(prev_index == -1 || i - cur_len > prev_index) {
				cur_len++;
			}
			else {
				
				if(cur_len > max_len) {
					max_len = cur_len;
					
					cur_len = i - prev_index;
				}
			}
			
			visited[(int)s.charAt(i)] = i;
		}
		
		if(cur_len > max_len)
			max_len = cur_len;
		
		return max_len;
	}
	
	public static void main(String[] args) {
		String ip = "ABDEFGABEF";
		System.out.println(getLongestUniqueSubstring(ip));
	}
}
