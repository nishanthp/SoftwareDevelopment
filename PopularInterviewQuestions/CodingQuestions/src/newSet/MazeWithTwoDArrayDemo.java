package newSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MazeWithTwoDArrayDemo {
	static LinkedList<Point> places = new LinkedList();

	public static void main(String[] args) {
		int[][] maze = new int[4][4];
		int i = 3;
		int j = 3;
		ratMaze(maze, i, j);
		while(!places.isEmpty()){
			Point temp =places.removeFirst();
			System.out.println(temp.x + " "+ temp.y);
		}
	}

	private static List<Point> ratMaze(int[][] maze, int i, int j) {
		if (i < 0 || j < 0) {
			return places;
		}
		if (maze[i][j] == 0) {
			return places;
		}
		places.addFirst(new Point(i, j));
		ratMaze(maze, i - 1, j);
		ratMaze(maze, i, j - 1);
		return places;
	}
}
