import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		
		System.out.println("ABCCED exists? " + exist(board, "ABCCED"));
		System.out.println("SEE exists? " + exist(board, "SEE"));
		System.out.println("ABCB exists? " + exist(board, "ABCB"));
		
		char[][] newBoard = {
		                     {'o','a','a','n'},
							 {'e','t','a','e'},
							 {'i','h','k','r'},
							 {'i','f','l','v'}
							};
		String[] words = {"oath","pea","eat","rain"};
		
		Arrays.stream(findWords(newBoard, words).toArray())
	      .forEach(System.out::println);

	}
	
	public static boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (exist(board, y, x, w, 0)) return true;
	    	}
	    }
	    return false;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> matches = new ArrayList<String>();
		for(String word : words) {
		    char[] w = word.toCharArray();
		    for (int y=0; y<board.length; y++) {
		    	for (int x=0; x<board[y].length; x++) {
		    		if (exist(board, y, x, w, 0)) matches.add(word);
		    	}
		    }
		}
	    return matches;
	}

	private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
		if (board[y][x] != word[i]) return false;
		board[y][x] ^= 256;
		boolean exist = exist(board, y, x+1, word, i+1)
			|| exist(board, y, x-1, word, i+1)
			|| exist(board, y+1, x, word, i+1)
			|| exist(board, y-1, x, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}

}
