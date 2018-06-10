package AccpetedSubmissions;

public class WordSearch {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	char[][] board;
	char[] word;

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.word = word.toCharArray();
		if (board.length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (checkWord(i, j, 0))
					return true;
			}
		}
		return false;
	}

	public boolean checkWord(int i, int j, int index) {
		int rowLength = board.length - 1;
		int colmnLength = board[0].length - 1;
		if (index == word.length)
			return true;
		if (i < 0 || j < 0 || i > rowLength || j > colmnLength)
			return false;
		if (word[index] != board[i][j])
			return false;
		// This is the important part. XOR a char with integer 256 (all 8 bit
		// 1's). This will require not to have visited[][], thus saving space.
		board[i][j] ^= 256;
		boolean exists = checkWord(i + 1, j, index + 1) || checkWord(i, j + 1, index + 1)
				|| checkWord(i - 1, j, index + 1) || checkWord(i, j - 1, index + 1);
		board[i][j] ^= 256;
		return exists;
	}

}
