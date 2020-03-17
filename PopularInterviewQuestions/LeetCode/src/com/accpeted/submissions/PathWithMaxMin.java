package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMaxMin {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Do not use DFS. Use BFS with pq.
	public int maximumMinimumPath(int[][] A) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				new Comparator<int[]>() {
					public int compare(int[] n1, int[] n2) {
						return n2[2] - n1[2];
					}
				});
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		boolean[][] visited = new boolean[A.length][A[0].length];
		pq.offer(new int[]{0, 0, A[0][0]});

		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				int[] curr = pq.poll();
				if (curr[0] == A.length - 1 && curr[1] == A[0].length - 1)
					return curr[2];
				for (int[] dir : dirs) {
					int nx = dir[0] + curr[0];
					int ny = dir[1] + curr[1];
					if (nx < 0 || ny < 0 || nx >= A.length || ny >= A[0].length
							|| visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					pq.offer(new int[]{nx, ny, Math.min(curr[2], A[nx][ny])});
				}
			}
		}
		return -1;
	}

}
