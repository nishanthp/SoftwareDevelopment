package com.accpeted.submissions;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailIdToOwner = new HashMap<String, String>();
		// bi-directional graph
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

		for (List<String> account : accounts) {
			String owner = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				if (!graph.containsKey(account.get(i))) {
					graph.put(account.get(i), new HashSet<String>());
				}
				emailIdToOwner.put(account.get(i), owner);
				if (i > 1) {
					String prev = account.get(i - 1);
					String curr = account.get(i);
					graph.get(curr).add(prev);
					graph.get(prev).add(curr);
				}
			}
		}

		List<List<String>> result = new LinkedList<>();
		Set<String> visited = new HashSet<String>();
		// dfs
		for (Map.Entry<String, String> entry : emailIdToOwner.entrySet()) {
			String startNode = entry.getKey();
			List<String> temp = new LinkedList<String>();
			if (!visited.contains(startNode)) {
				visited.add(startNode);
				dfs(graph, startNode, visited, temp);
				Collections.sort(temp);
				temp.add(0, entry.getValue());
				result.add(temp);
			}
		}
		return result;
	}

	private void dfs(Map<String, Set<String>> graph, String startNode,
			Set<String> visited, List<String> temp) {
		temp.add(startNode);
		for (String next : graph.get(startNode)) {
			if (!visited.contains(next)) {
				visited.add(next);
				dfs(graph, next, visited, temp);
			}
		}
	}

}
