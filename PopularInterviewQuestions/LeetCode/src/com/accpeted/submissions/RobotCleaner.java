package com.accpeted.submissions;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaner {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public void cleanRoom(Robot robot) {
		Set<String> set = new HashSet<String>();
		cleanNow(robot, set, 0, 0, 0);
	}

	private void cleanNow(Robot robot, Set<String> visited, int currDir, int x,
			int y) {
		String path = x + "->" + y;
		if (visited.contains(path))
			return;
		visited.add(path);
		robot.clean();
		for (int i = 0; i < 4; i++) {
			if (robot.move()) {
				int nx = x + dirs[currDir][0];
				int ny = y + dirs[currDir][1];
				cleanNow(robot, visited, currDir, nx, ny);
				robot.turnRight();
				robot.turnRight();
				robot.move();
				robot.turnLeft();
				robot.turnLeft();
			}
			robot.turnRight();
			currDir = (currDir + 1) % 4;
		}
	}

}

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the
	// current cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();
	public void turnRight();

	// Clean the current cell.
	public void clean();
}