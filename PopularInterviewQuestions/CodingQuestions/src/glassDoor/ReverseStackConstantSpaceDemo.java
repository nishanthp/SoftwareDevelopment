package glassDoor;

import java.util.Stack;

public class ReverseStackConstantSpaceDemo {
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) {
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		reverseStack();
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

	private static void reverseStack() {
		if (s.isEmpty()) {
			return;
		}

		int method_stack_var = s.pop();

		reverseStack();

		insert_at_bottom(method_stack_var);

	}

	private static void insert_at_bottom(int method_stack_var) {
		if (s.isEmpty()) {
			s.push(method_stack_var);
		} else {
			int temp = s.pop();
			insert_at_bottom(method_stack_var);
			s.push(temp);
		}

	}
}
