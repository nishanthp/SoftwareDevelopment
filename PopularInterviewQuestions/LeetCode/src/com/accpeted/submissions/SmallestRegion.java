package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestRegion {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String findSmallestRegion(List<List<String>> regions, String region1,
			String region2) {
		Map<String, String> map = new HashMap<String, String>();
		for (List<String> region : regions) {
			for (int i = 1; i < region.size(); i++) {
				map.put(region.get(i), region.get(0));
			}
		}

		Set<String> nodeToParent = new HashSet<String>();
		while (region1 != null) {
			nodeToParent.add(region1);
			region1 = map.get(region1);
		}

		while (region2 != null) {
			if (nodeToParent.contains(region2))
				return region2;
			region2 = map.get(region2);
		}
		return null;
	}

}
