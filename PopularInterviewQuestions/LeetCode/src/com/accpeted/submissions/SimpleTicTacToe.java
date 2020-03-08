package com.accpeted.submissions;

public class SimpleTicTacToe {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean validTicTacToe(String[] board) {
		int xNumber = 0;
		int oNumber = 0;
		for (String curr : board) {
			for (char c : curr.toCharArray()) {
				if (c == 'X')
					xNumber++;
				if (c == 'O')
					oNumber++;

			}
		}
		boolean xWins = wins(board, 'X');
		boolean oWins = wins(board, 'O');
		if (xWins) {
			if (!oWins && xNumber > oNumber && xNumber - oNumber < 2)
				return true;
		} else if (oWins) {
			if (!xWins && xNumber == oNumber)
				return true;
		} else {
			if (xNumber >= oNumber && Math.abs(xNumber - oNumber) < 2)
				return true;
		}
		return false;
	}

	private boolean wins(String[] board, char c) {
		boolean wins = false;
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == c && board[i].charAt(1) == c
					&& board[i].charAt(2) == c)
				return true;
			if (board[0].charAt(i) == c && board[1].charAt(i) == c
					&& board[2].charAt(i) == c)
				return true;
		}

		if (board[1].charAt(1) == c) {
			if (board[0].charAt(2) == c && board[2].charAt(0) == c)
				return true;
			if (board[0].charAt(0) == c && board[2].charAt(2) == c)
				return true;
		}
		return false;
	}

}
