package newSet;

public class KnightTourDemo {
	public static void main(String[] args) {
		int[][] board = new int[8][8];
		int i = 0;
		int j = 0;
		knightTour(board, i, j);
	}

	private static boolean knightTour(int[][] board, int i, int j) {
		if(i<0 || j<0){
			return false;
		}
		if (knightTour(board, i + 1, j) || knightTour(board, i + 1, j - 1) || knightTour(board, i + 1, j + 1)
				|| knightTour(board, i, j - 1) || knightTour(board, i, j + 1) || knightTour(board, i - 1, j - 1)
				|| knightTour(board, i + 1, j + 1)) {
			// add to the array.
		}
		return true;

	}

}
