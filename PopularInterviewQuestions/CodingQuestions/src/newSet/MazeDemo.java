package newSet;

import java.util.ArrayList;
import java.util.LinkedList;
// This is without the 2D array.
public class MazeDemo {
	public static void main(String[] args) {
		int N = 4;
		LinkedList<Point> places = new LinkedList<>();
		int i = N - 1;
		int j = N - 1;
		LinkedList<Point> res = ratMaze(i, j, places);
		while (!res.isEmpty()) {
			Point temp = res.removeFirst();
			System.out.println(temp.x + " " + temp.y);
		}
	}

	private static LinkedList<Point> ratMaze(int i, int j, LinkedList<Point> places) {
		if (i < 0 || j < 0) {
			return places;
		}
		if (i < j) {
			return places;
		}
		places.addFirst(new Point(i, j));
		ratMaze(i - 1, j, places);
		ratMaze(i, j - 1, places);
		return places;
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
