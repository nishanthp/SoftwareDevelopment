package popularInProb;

import java.util.Stack;

public class UndoRedoDemo {
	static String input = "abcd";

	public static void main(String[] args) {
		UndoCommand undoCommand = new UndoCommand(input, 'd');
		RedoCommand redoCommand = new RedoCommand(input, 'd');
		BrokerUndoRedo undoRedo = new BrokerUndoRedo();
		undoRedo.type(input);
		undoRedo.undo(undoCommand);
		undoRedo.redo(redoCommand);
	}
}

class BrokerUndoRedo {
	private Stack<popularInProb.Command> undoStack = new Stack<>();
	private Stack<popularInProb.Command> redoStack = new Stack<>();

	public void type(String input) {
		int i = 0;
		for (char eachChar : input.toCharArray()) {
			undoStack.push(new UndoCommand(input, eachChar));
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
	public char c;

	public UndoCommand(String inputString, char input) {
		this.inputString = inputString;
		this.c = input;
	}

	@Override
	public void execute() {
		char[] temp = inputString.toCharArray();
		char[] result = new char[temp.length-1];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != this.c) {
				result[i] = temp[i];
			}
		}
		this.inputString = new String(result);
		System.out.println(this.inputString);
	}
}

class RedoCommand implements Command {
	public String inputString;
	public char c;

	public RedoCommand(String inputString, char input) {
		this.inputString = inputString;
		this.c = input;
	}

	@Override
	public void execute() {
		char[] temp = inputString.toCharArray();
		char[] result = new char[temp.length + 1];
		int j = temp.length;
		for (int i = 0; i < temp.length; i++) {
			result[i] = temp[i];
		}
		result[j] = this.c;
		this.inputString = new String(result);
		System.out.println(this.inputString);

	}
}

/*
 * class Char { char c; int pos;
 * 
 * Char(char c, int position) { this.c = c; this.pos = position; } }
 */