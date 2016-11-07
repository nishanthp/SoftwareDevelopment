package Stack;

import java.util.Stack;

public class StackOrderDemo {
	static Stack<Integer> unordered = new Stack<>();
	static Stack<Integer> ordered = new Stack<>();

	public static void main(String[] args) {
		unordered.push(8);
		unordered.push(7);
		unordered.push(3);
		unordered.push(5);
		unordered.push(4);

		StackOrderDemo order = new StackOrderDemo();
		order.sortElementsInStack(unordered, ordered);

		// print.
		while (!ordered.isEmpty()) {
			System.out.println(ordered.pop());
		}

	}

	public void sortElementsInStack(Stack<Integer> unorderedStack, Stack<Integer> orderedStack) {
		while (!unorderedStack.isEmpty()) {
			int temp = unorderedStack.pop();
			while (!orderedStack.isEmpty() && orderedStack.peek() > temp) {
				unorderedStack.push(orderedStack.pop());
			}
			orderedStack.push(temp);
		}
	}
}
