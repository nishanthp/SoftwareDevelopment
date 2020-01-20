package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFileSystem {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String path : paths) {
			String[] parts = path.split(" ");
			String dirPath = parts[0];
			for (int i = 1; i < parts.length; i++) {
				String fileName = parts[i].substring(0, parts[i].indexOf('('));
				String content = parts[i].substring(parts[i].indexOf('('),
						parts[i].indexOf(')') + 1);
				map.putIfAbsent(content, new ArrayList<String>());
				map.get(content).add(new StringBuffer().append(dirPath)
						.append("/").append(fileName).toString());
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1)
				continue;
			result.add(entry.getValue());
		}
		return result;
	}

}
