package com.accpeted.submissions;

public class ConvertBinaryNumberinLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int getDecimalValue(ListNode head) {
		// Deque<Integer> stack = new ArrayDeque<Integer>();
		int sum = 0;
		while (head != null) {
			// stack.push(head.val);
			sum = (sum << 1) | head.val;
			head = head.next;
		}
		// int i =0 ;
		// int sum = 0;
		// while(!stack.isEmpty()){
		// sum += Math.pow(2, i++)* stack.pop();
		// }
		return sum;
	}

}
