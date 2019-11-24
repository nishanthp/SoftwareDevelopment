package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	class MyStack {
		Queue<Integer> q1;
		Queue<Integer> q2;
		int top = 0;
		/** Initialize your data structure here. */
		public MyStack() {
			q1 = new LinkedList<Integer>();
			q2 = new LinkedList<Integer>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			top = x;
			q1.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			while (q1.size() > 1) {
				top = q1.remove();
				q2.add(top);
			}
			// Below lines are the best part of the solution.
			int ret = q1.remove();
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			return ret;
		}

		/** Get the top element. */
		public int top() {
			return top;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return q1.isEmpty();
		}
	}

}
