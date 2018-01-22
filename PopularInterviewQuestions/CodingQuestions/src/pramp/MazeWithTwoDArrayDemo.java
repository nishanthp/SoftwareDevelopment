package pramp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MazeWithTwoDArrayDemo {
	static LinkedList<Point> places = new LinkedList();

	public static void main(String[] args) {
		int[][] maze = new int[4][4];
		maze[0][0] = 1;
		maze[0][1] = 0;
		maze[0][2] = 0;
		maze[0][3] = 0;

		maze[1][0] = 1;
		maze[1][1] = 1;
		maze[1][2] = 0;
		maze[1][3] = 0;

		maze[2][0] = 0;
		maze[2][1] = 1;
		maze[2][2] = 0;
		maze[2][3] = 0;

		maze[3][0] = 1;
		maze[3][1] = 1;
		maze[3][2] = 1;
		maze[3][3] = 1;

		int i = 3;
		int j = 3;
		ratMaze(maze, i, j);
		while (!places.isEmpty()) {
			Point temp = places.removeFirst();
			System.out.println(temp.x + " " + temp.y);
		}
	}

	private static boolean ratMaze(int[][] maze, int i, int j) {
		if (i < 0 || j < 0) {
			return false;
		}
		if (maze[i][j] == 0) {
			return false;
		}
		if (i == 0 && j == 0) {
			places.addFirst(new Point(i, j));
			return true;
		}

		if (ratMaze(maze, i - 1, j) || ratMaze(maze, i, j - 1)) {
			places.addFirst(new Point(i, j));
		}
		return true;
	}
}
