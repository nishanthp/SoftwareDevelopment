package com.practice.queue;

import java.util.Stack;

public class QueueUsingTwoStacksDemo {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		int temp = queue.dequeue();
		System.out.println(temp);
		System.out.println(queue.peek());
		System.out.println("Queue Size:" + queue.size());
	}
}

class Queue {
	Stack<Integer> oldStack = new Stack<>();
	Stack<Integer> newStack = new Stack<>();

	public void enqueue(int data) {
		oldStack.add(data);
	}

	public int dequeue() {
		shiftElementsfromOldtoNewStack();
		if (newStack.isEmpty()) {
			System.out.println("Queue is empty.");
		}
		return newStack.pop();
	}

	private void shiftElementsfromOldtoNewStack() {
		if (newStack.isEmpty()) {
			while (!oldStack.isEmpty()) {
				newStack.push(oldStack.pop());
			}
		}

	}

	public int peek() {
		shiftElementsfromOldtoNewStack();
		return newStack.peek();
	}

	public int size() {
		return oldStack.size() + newStack.size();
	}
}
