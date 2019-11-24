package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class MyQueue {
		Deque<Integer> stack1;
		Deque<Integer> stack2;
		int first = 0;
		/** Initialize your data structure here. */
		public MyQueue() {
			stack1 = new ArrayDeque<Integer>();
			stack2 = new ArrayDeque<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			if (stack1.isEmpty()) {
				first = x;
			}
			stack1.push(x);
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			while (stack1.size() > 1) {
				first = stack1.pop();
				stack2.push(first);
			}
			int ret = stack1.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return ret;
		}

		/** Get the front element. */
		public int peek() {
			return first;
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stack1.isEmpty();
		}
	}

}
