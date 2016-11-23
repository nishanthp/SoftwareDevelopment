package PopularInProb;

import java.util.Stack;

public class UndoRedoDemo {
	static String input = "abcd";

	public static void main(String[] args) {
		Char c = new Char('d', 3);
		UndoCommand undoCommand = new UndoCommand(input, c);
		RedoCommand redoCommand = new RedoCommand(input, c);
		BrokerUndoRedo undoRedo = new BrokerUndoRedo();
		undoRedo.type(input);
		undoRedo.undo(undoCommand);
		undoRedo.redo(redoCommand);
	}
}

class BrokerUndoRedo {
	private Stack<PopularInProb.Command> undoStack = new Stack<>();
	private Stack<PopularInProb.Command> redoStack = new Stack<>();

	public void type(String input) {
		int i = 0;
		for (char eachChar : input.toCharArray()) {
			undoStack.push(new UndoCommand(input, new Char(eachChar, i++)));
		}
	}

	public void undo(Command command) {
		if (undoStack.isEmpty()) {
			System.out.println("There is nothing to undo.");
		} else {
			UndoCommand undoC = (UndoCommand) undoStack.pop();
			undoC.execute();
			redoStack.push(new RedoCommand(undoC.inputString, undoC.c));
		}
	}

	public void redo(Command command) {
		if (redoStack.isEmpty()) {
			System.out.println("There is nothing to redo.");
		} else {
			RedoCommand redoC = (RedoCommand) redoStack.pop();
			redoC.execute();
			undoStack.push(new UndoCommand(redoC.inputString, redoC.c));
		}
	}

}

interface Command {
	public void execute();
}

class UndoCommand implements Command {
	public String inputString;
	public Char c;

	public UndoCommand(String inputString, Char input) {
		this.inputString = inputString;
		this.c = input;
	}

	@Override
	public void execute() {
		char[] temp = inputString.toCharArray();
		char[] result = new char[temp.length];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != this.c.c) {
				result[i] = temp[i];
			}
		}
		System.out.println(new String(result));
	}
}

class RedoCommand implements Command {
	public String inputString;
	public Char c;

	public RedoCommand(String inputString, Char input) {
		this.inputString = inputString;
		this.c = input;
	}

	@Override
	public void execute() {
		char[] temp = inputString.toCharArray();
		char[] result = new char[temp.length];
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[j] == this.c.pos) {
				result[i] = this.c.c;
			} else {
				result[j] = temp[j];
				j++;
			}
		}
		System.out.println(new String(result));

	}
}

class Char {
	char c;
	int pos;

	Char(char c, int position) {
		this.c = c;
		this.pos = position;
	}
}