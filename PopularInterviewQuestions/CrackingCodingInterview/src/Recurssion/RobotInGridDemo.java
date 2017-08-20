package Recurssion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RobotInGridDemo {
	public static void main(String[] args) {
		boolean[][] matrix = new boolean[4][4];
		ArrayList<Point> path = new ArrayList<>();
		pathToDest(matrix, path, 3, 3);
	}

	private static ArrayList<Point> pathToDest(boolean[][] matrix, ArrayList<Point> path, int i, int j) {
		if (i < 0 || j < 0) {
			return path;
		}
		if (matrix[i][j] == false) {
			return path;
		}

		Point temp = new Point();
		temp.x = i;
		temp.y = j;
		path.add(temp);
		pathToDest(matrix, path, i - 1, j);
		pathToDest(matrix, path, i, j - 1);
		return path;
	}

}

class Point {
	int x;
	int y;
}
