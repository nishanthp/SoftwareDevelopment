package newSet;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// O(k^q/2 + k^q/2)= O(k^q/2) where q is average number of friends each person has.
public class BiBFSDemo {
	static HashMap<Integer, Person> people = new HashMap<>();

	public static void main(String[] args) {
		int number = 11;
		for (int i = 1; i < number; i++) {
			Person temp = new Person(i);
			people.put(i, temp);
		}

		int[][] connections = { { 1, 4 }, { 1, 2 }, { 1, 3 }, { 3, 2 }, { 4, 6 }, { 3, 7 }, { 6, 9 }, { 9, 10 },
				{ 5, 10 }, { 2, 5 }, { 3, 7 } };

		for (int[] connection : connections) {
			Person psource = people.get(connection[0]);
			psource.addFriend(connection[1]);

			Person pdest = people.get(connection[1]);
			pdest.addFriend(connection[0]);
		}

		BiBFSDemo bbfs = new BiBFSDemo();
		LinkedList<PathNode> mutualConnection = bbfs.findBiBFS(1, 10);
		while (mutualConnection.iterator().hasNext()) {
			System.out.println(mutualConnection.poll().getPerson().getId());
		}

	}

	public LinkedList<PathNode> findBiBFS(int perId1, int perId2) {
		BFSData source = new BFSData(people.get(perId1));
		BFSData dest = new BFSData(people.get(perId2));

		while (!source.isFinished() && !dest.isFinished()) {
			Integer collusion = searchOneLevel(source, dest);
			if (collusion != null) {
				return mergePaths(source, dest, collusion);
			}

			collusion = searchOneLevel(dest, source);
			if (collusion != null) {
				return mergePaths(source, dest, collusion);
			}
		}
		return null;
	}

	private LinkedList<PathNode> mergePaths(BFSData source, BFSData dest, Integer collusion) {
		PathNode end1 = source.visited.get(collusion);
		PathNode end2 = dest.visited.get(collusion);
		LinkedList<PathNode> sourceList = end1.collapsePath(true);
		LinkedList<PathNode> destList = end2.collapsePath(false);
		destList.removeFirst();
		sourceList.addAll(destList);
		return sourceList;
	}

	private Integer searchOneLevel(BFSData source, BFSData dest) {
		int count = source.toVisit.size();
		for (int i = 0; i < count; i++) {
			Integer id = source.toVisit.poll();
			PathNode current = source.visited.get(id);
			// collusion has happened.
			if (dest.visited.containsKey(id)) {
				return id;
			}
			Person intermediate = people.get(id);
			if (!intermediate.getFriends().isEmpty()) {
				for (Integer perId : intermediate.getFriends()) {
					if (!source.visited.containsKey(perId)) {
						source.toVisit.add(perId);
						PathNode next = new PathNode(people.get(perId), current);
						source.visited.put(perId, next);
					}
				}
			}

		}
		return null;
	}
}

class BFSData {
	Queue<Integer> toVisit = new LinkedList<>();
	HashMap<Integer, PathNode> visited = new HashMap<>();

	public BFSData(Person root) {
		this.toVisit.add(root.getId());
		PathNode r = new PathNode(root, null);
		this.visited.put(root.getId(), r);
	}

	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}

class Person {
	int id;
	ArrayList<Integer> friends = new ArrayList<Integer>();

	public Person(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void addFriend(int id) {
		friends.add(id);
	}

	public ArrayList<Integer> getFriends() {
		return friends;
	}

}

class PathNode {
	Person person;
	PathNode previousNode;

	public PathNode(Person per, PathNode node) {
		this.person = per;
		this.previousNode = node;
	}

	public Person getPerson() {
		return person;
	}

	public LinkedList<PathNode> collapsePath(boolean includeRoot) {
		LinkedList<PathNode> list = new LinkedList<>();
		PathNode p = this;
		while (p != null) {
			if (includeRoot) {
				list.addFirst(p);
			} else {
				list.addLast(p);
			}
			p = p.previousNode;
		}

		return list;
	}
}