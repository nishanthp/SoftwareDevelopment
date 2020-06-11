package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Program> p = new ArrayList<Program>();
		System.out.println(
				p.stream().filter(program -> program.name.equals("PSA"))
						.findFirst().isEmpty());
	}

	// Very important. classic example of a BFS problem.
	public int orangesRotting(int[][] grid) {
		int goodOranges = 0;
		int counter = 0;
		// to control what to visit. DFS is not an option here.
		int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> badOranges = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// need to know the position of all the bad oranges.
				if (grid[i][j] == 2)
					badOranges.add(new int[]{i, j});
				else if (grid[i][j] == 1)
					goodOranges += 1;
			}
		}
		if (goodOranges == 0)
			return counter;
		while (!badOranges.isEmpty()) {
			int size = badOranges.size();
			counter++;
			for (int i = 0; i < size; i++) {
				int[] point = badOranges.remove();
				for (int[] pos : positions) {
					int curX = point[0] + pos[0];
					int curY = point[1] + pos[1];
					if (curX < 0 || curY < 0 || curX >= grid.length
							|| curY >= grid[0].length || grid[curX][curY] == 2
							|| grid[curX][curY] == 0)
						continue;
					grid[curX][curY] = 2;
					goodOranges -= 1;
					badOranges.add(new int[]{curX, curY});
				}
			}
		}
		// if you cannot reach all good oranges, answer is -1.
		return goodOranges == 0 ? counter - 1 : -1;
	}

}

class Program {
	public Program(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	String name;

}
