package stack;

import java.util.ArrayList;
import java.util.Stack;

public class NCelebrityDemo {
	static ArrayList<People> people = new ArrayList<>();

	public static void main(String[] args) {
		A aObject = new A("a");
		B bObject = new B("b");
		C cObject = new C("c");
		D dObject = new D("d");

		ArrayList aKnows = new ArrayList<>();
		aKnows.add("c");
		aKnows.add("d");
		aObject.setKnows(aKnows);

		ArrayList bKnows = new ArrayList<>();
		bKnows.add("a");
		bKnows.add("c");
		bObject.setKnows(bKnows);

		ArrayList cKnows = new ArrayList<>();
		cObject.setKnows(cKnows);

		ArrayList dKnows = new ArrayList<>();
		dKnows.add("b");
		dKnows.add("c");
		dObject.setKnows(dKnows);
		people.add(aObject);
		people.add(bObject);
		people.add(cObject);
		people.add(dObject);
		System.out.println(findCelebrity());
	}

	private static String findCelebrity() {
		Stack<People> stack = new Stack<>();

		// Add everybody to the stack.
		for (People person : people) {
			stack.push(person);
		}

		// remove two people from stack to compare.

		People person1 = stack.pop();
		People person2 = stack.pop();

		while (stack.size() > 1) {
			if (knows(person1, person2)) {
				person1 = stack.pop();
			} else {
				person2 = stack.pop();
			}
		}

		People lastPerson = stack.pop();

		if (knows(lastPerson, person1)) {
			lastPerson = person1;
		} else if (knows(lastPerson, person2)) {
			lastPerson = person2;
		}

		// At this point I might have found the potential celebrity.
		for (int i = 0; i < people.size(); i++) {
			String current = people.get(i).n;
			if (!current.equals(lastPerson.n)) {
				if (knows(lastPerson, people.get(i)) || !knows(people.get(i), lastPerson)) {
					return "There is no celebrity in the room.";
				}
			}

		}
		return lastPerson.n;
	}

	private static boolean knows(People person1, People person2) {
		if (person1.knows.contains(person2.n)) {
			return true;
		}
		return false;
	}
}

abstract class People {
	String n = null;
	ArrayList<String> knows = new ArrayList<>();
}

class A extends People {

	public ArrayList<String> getKnows() {
		return super.knows;
	}

	public void setKnows(ArrayList<String> knows) {
		super.knows = knows;
	}

	A(String name) {
		super.n = name;
	}
}

class B extends People {

	public ArrayList<String> getKnows() {
		return knows;
	}

	public void setKnows(ArrayList<String> knows) {
		this.knows = knows;
	}

	B(String name) {
		super.n = name;
	}
}

class C extends People {

	public ArrayList<String> getKnows() {
		return super.knows;
	}

	public void setKnows(ArrayList<String> knows) {
		super.knows = knows;
	}

	C(String name) {
		super.n = name;
	}
}

class D extends People {

	public ArrayList<String> getKnows() {
		return super.knows;
	}

	public void setKnows(ArrayList<String> knows) {
		super.knows = knows;
	}

	D(String name) {
		super.n = name;
	}
}