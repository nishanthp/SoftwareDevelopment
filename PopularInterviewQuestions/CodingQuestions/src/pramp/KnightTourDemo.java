package pramp;

public class KnightTourDemo {
	static int count = 0;

	public static void main(String[] args) {
		int[][] board = new int[8][8];
		int i = 0;
		int j = 0;

		// fill up the array
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y] = 0;
			}
		}

		knightTour(board, i, j);
		System.out.println(count);
	}

	private static boolean knightTour(int[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if (count >= 64)
			return true;
		if (board[i][j] == 1)
			return false;
		count += 1;
		board[i][j] = 1;
		System.out.println(i + " " + j + "    " + count);
		knightTour(board, i + 1, j + 2);
		knightTour(board, i - 1, j + 2);
		knightTour(board, i + 1, j - 2);
		knightTour(board, i - 1, j - 2);
		knightTour(board, i + 2, j + 1);
		knightTour(board, i - 2, j + 1);
		knightTour(board, i + 2, j - 1);
		knightTour(board, i - 2, j - 1);

		return true;
	}

}
