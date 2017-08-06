package BitManipulation;

import java.util.Currency;

public class FlipBitToWinDemo {
	public static void main(String[] args) {
		int num = 1775;
		System.out.println(shiftBitToWin(num));
	}

	private static int shiftBitToWin(int num) {
		int currentLenght = 0;
		int previousLength = 0;
		int maxLength = 0;
		while (num != 0) {
			// the bit is 1.
			if ((num & 1) == 1) {
				currentLenght++;
			} else {
				previousLength = (num & 2) == 0 ? 0 : currentLenght;
				currentLenght = 0;
			}
			maxLength = Math.max(previousLength + currentLenght + 1, maxLength);
			num >>>= 1;
		}
		return maxLength;

	}
}
