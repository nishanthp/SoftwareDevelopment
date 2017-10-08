package newSet;

public class DroneHeightDemo {
	public static void main(String[] args) {
		// input data.
		int[][] input = new int[5][3];
		input[0][0] = 0;
		input[0][1] = 2;
		input[0][2] = 10;

		input[1][0] = 3;
		input[1][1] = 5;
		input[1][2] = 0;

		input[2][0] = 9;
		input[2][1] = 20;
		input[2][2] = 6;

		input[3][0] = 10;
		input[3][1] = 12;
		input[3][2] = 15;

		input[4][0] = 10;
		input[4][1] = 10;
		input[4][2] = 8;
		int val = calculateMinEnergy(input);
		System.out.println("Minimum energy required " + val + "kWh");
	}

	private static int calculateMinEnergy(int[][] input) {
		int initialVal = -1;
		int peakVal = -1;
		for (int[] eachRow : input) {
			if (initialVal == -1) {
				initialVal = eachRow[2];
			} else if (eachRow[2] > peakVal) {
				peakVal = eachRow[2];
			}
		}
		return (peakVal - initialVal);
	}
}
