package Stack;

import java.util.Stack;

public class MinVauleInStackDemo {
	static Stack<StackNode> stack = new Stack();
	static int minimumValue = Integer.MAX_VALUE;

	public static void main(String[] args) {
		MinVauleInStackDemo demo = new MinVauleInStackDemo();
		demo.push(10);
		demo.push(9);
		demo.push(12);
		demo.push(7);
		demo.push(15);
		System.out.println(demo.minValue());
		demo.pop();
		demo.pop();
		System.out.println(demo.peek());
		System.out.println(demo.minValue());
	}

	public int peek() {
		return stack.peek().data;
	}

	public int minValue() {
		return stack.peek().getMinValueSoFar();
	}

	public void push(int data) {
		StackNode temp;
		minimumValue = Math.min(minimumValue, data);
		temp = new StackNode(data);
		temp.setMinValueSoFar(minimumValue);
		stack.push(temp);
	}

	public int pop() {
		return stack.pop().data;
	}
}

class StackNode {
	int data;
	int minValueSoFar;

	public StackNode(int data) {
		this.data = data;

	}

	public void setMinValueSoFar(int minValueSoFar) {
		this.minValueSoFar = minValueSoFar;
	}

	public int getMinValueSoFar() {
		return minValueSoFar;
	}
}