package AccpetedSubmissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

// Works for duplicate values. Always returns the first pair found (duplicate or non duplicate).
// To return all pairs, need to convert Integer [] to int [].
public class TwoSum {
	HashMap<Integer, ArrayList<Integer>> values = new HashMap<Integer, ArrayList<Integer>>();

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int[] twoSum(int[] nums, int target) {
		// Populate the hashmap
		int counter = 0;
		ArrayList<Integer> temp;
		for (int entry : nums) {
			if (values.containsKey(entry)) {
				temp = values.get(entry);
				temp.add(counter);
				values.put(entry, temp);

			} else {
				temp = new ArrayList<Integer>();
				temp.add(counter);
				values.put(entry, temp);
			}

			counter += 1;
		}

		for (Entry<Integer, ArrayList<Integer>> entry : values.entrySet()) {
			int tempVar = target - entry.getKey();
			if (tempVar == entry.getKey()) {
				if (entry.getValue().size() < 2) {
					return null;
				} else {
					return new int[] { entry.getValue().get(0), entry.getValue().get(1) };
				}

			}
			if (values.containsKey(tempVar)) {
				return new int[] { entry.getValue().get(0), values.get(tempVar).get(0) };
			}
		}
		return null;
	}

}
