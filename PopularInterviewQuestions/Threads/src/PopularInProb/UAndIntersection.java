package PopularInProb;

import java.util.HashSet;
import java.util.Iterator;

public class UAndIntersection {
	static HashSet<String> common = new HashSet<>();

	public static void main(String[] args) {
		HashSet<String> stringA = new HashSet<>();
		stringA.add("Hello");
		stringA.add("World");
		HashSet<String> stringB = new HashSet<>();
		stringB.add("Hello");
		stringB.add("intersection");
		UAndIntersection unionAndIntersection = new UAndIntersection();
		unionAndIntersection.findIntersectionOfTwoStrings(stringA, stringB);

		for (String eachString : common) {
			System.out.println(eachString);
		}
	}

	public HashSet<String> findUnionOfTwoStrings(HashSet<String> input1, HashSet<String> input2) {
		input1.addAll(input2);
		return input1;
	}

	public void findIntersectionOfTwoStrings(HashSet<String> input1, HashSet<String> input2) {
		Iterator<String> input_Iterator = input1.iterator();
		while (input_Iterator.hasNext()) {
			String tempString = input_Iterator.next();
			if (input2.contains(tempString)) {
				common.add(tempString);
			}
		}
	}
}
