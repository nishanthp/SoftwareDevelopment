package pramp;

import javax.print.attribute.standard.MediaSize.Other;

public class OtherTwoSidesOfRightAngleTDemo {
	public static void main(String[] args) {
		OtherTwoSidesOfRightAngleTDemo d = new OtherTwoSidesOfRightAngleTDemo();
		int[] result = d.findOtherTwoSides(60);
		for (int side : result) {
			System.out.println(side);
		}

	}

	public int[] findOtherTwoSides(int a) {
		int[] sides = new int[2];
		int hyp = -1;
		int otherSide = -1;
		if (a % 2 == 0) {
			hyp = (a * a) / 4 + 1;
			otherSide = (a * a) / 4 - 1;
		} else {
			hyp = (a * a + 1) / 2;
			otherSide = (a * a - 1) / 2;
		}

		sides[0] = hyp;
		sides[1] = otherSide;
		return sides;
	}
}
