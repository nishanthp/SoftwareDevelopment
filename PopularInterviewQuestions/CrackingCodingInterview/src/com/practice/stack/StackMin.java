package com.practice.stack;

import java.util.*;

public class StackMin {
	public static void main(String[] args) {
		StackMinimum minStack = new StackMinimum();
		minStack.push(12);
		minStack.push(1);
		minStack.push(13);
		minStack.push(16);
		minStack.push(9);

		System.out.println(minStack.min());

	}
}

class StackMinimum {
	Stack<Stacknode_1> stack = new Stack<>();

	public void push(int data) {
		int min = Math.min(data, min());
		Stacknode_1 temp = new Stacknode_1(data, min);
		stack.push(temp);
	}

	public Stacknode_1 pop() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.pop();
	}

	public Stacknode_1 peek() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.peek();
	}

	public int min() {
		if (stack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return stack.peek().minValue;
		}
	}
}

class Stacknode_1 {
	int minValue;
	int value;

	public Stacknode_1(int data, int minValue) {
		this.value = data;
		this.minValue = minValue;
	}
}
