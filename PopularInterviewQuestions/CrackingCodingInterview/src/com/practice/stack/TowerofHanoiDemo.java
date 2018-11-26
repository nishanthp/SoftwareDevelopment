package com.practice.stack;

public class TowerofHanoiDemo {
	// Without a special class for tower.
	public static void main(String[] args) {
		TowerofHanoiDemo demo = new TowerofHanoiDemo();
		demo.moveDisks(3, 'A', 'B', 'C');
	}

	public void moveDisks(int n, char begin, char buffer, char end) {

		if (n == 1) {
			System.out.println("Begin    " + begin + "    END    " + end);
		} else {
			moveDisks(n - 1, begin, end, buffer);
			System.out.println("Begin    " + begin + "    END    " + end);
			moveDisks(n - 1, buffer, begin, end);
		}

	}
}
