package leetCode.String;
import java.util.*;

class WordSearch2 {
    
    private static boolean searchWord(char[][] board, String word) {
        
        int row = board.length;
        int col = board[0].length;
        
        char ch = word.charAt(0);
        
        boolean flag = false;
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                
                if(board[r][c] == ch) {
                    flag = searchWordUtil(board, r, c, word, 0);
                }
            }
        }
        
        return flag;
    }
    
    private static boolean searchWordUtil(char[][] board, int row, int col, String word, int index) {
        
        if(index == word.length()) {
            return true;
        }
        
        if(row < 0 || row >= board.length) {
            return false;
        }
        
        if(col < 0 || col >= board[0].length) {
            return false;
        }
        
        if(board[row][col] != word.charAt(index)) {
            return false;
        }
        
        board[row][col] ^= 256;
        
        boolean isWord = searchWordUtil(board, row, col + 1, word, index + 1) 
                        || searchWordUtil(board, row + 1, col, word, index + 1)
                        || searchWordUtil(board, row, col - 1, word, index + 1)
                        || searchWordUtil(board, row - 1, col, word, index + 1);
        
        board[row][col] ^= 256;
        
        return isWord;
        
        
    } 
    
    public static ArrayList<String> findWords(char[][] board, String[] words) {
        
        if(words == null || words.length == 0) {
            return null;
        }
        
        ArrayList<String> result = new ArrayList<String>();
        
        for(String word : words) {
            
            if(searchWord(board, word)) {
                result.add(word);
            }
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
    	
    	String[] words = {"oath", "eat", "pea","rain"};
    	char[][] board = {{'o', 'a', 'a', 'n'},
    					  {'e', 't', 'a', 'e'},
    					  {'i', 'h', 'k', 'r'},
    					  {'i', 'f', 'l', 'v'}
    					};
    	
    	ArrayList<String> result = findWords(board, words);
    	
    	for(String word: result) {
    		System.out.println(word);
    	}
    }
}