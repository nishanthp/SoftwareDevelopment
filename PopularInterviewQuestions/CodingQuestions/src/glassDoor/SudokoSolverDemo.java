package glassDoor;

public class SudokoSolverDemo {
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		SudokoSolverDemo d = new SudokoSolverDemo();
		d.solveSudoko(board);
		
	}

	public boolean solveSudoko(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ' ') {
					// put a character.
					for (char c = '1'; c <= '9'; c += 1) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
						}
						if (solveSudoko(board))
							return true;
						else {
							board[i][j] = ' ';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int column, char ch) {
		for (int k = 0; k < 9; k++) {
			if (board[row][k] != ' ' && board[row][k] == ch)
				return false;
			if (board[k][column] != ' ' && board[k][column] == ch)
				return false;
			if (board[(row / 3) * 3 + k / 3][(column / 3) * 3 + k % 3] != ' '
					&& board[(row / 3) * 3 + k / 3][(column / 3) * 3 + k % 3] == k)
				return false;
		}
		return true;
	}
}
