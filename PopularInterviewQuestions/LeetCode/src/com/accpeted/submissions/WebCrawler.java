package com.accpeted.submissions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WebCrawler {

	public static void main(String[] args) {
		// Ran on leetcode.

		String s = "abcdef";
		System.out.println(s.contains("f"));

	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		List<String> result = new LinkedList<String>();
		String domainName = getDomainFromURL(startUrl);
		queue.offer(startUrl);
		visited.add(startUrl);
		result.add(startUrl);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currUrl = queue.poll();
				for (String neighbor : htmlParser.getUrls(currUrl)) {
					if (!visited.contains(neighbor) && getDomainFromURL(currUrl)
							.equals(getDomainFromURL(neighbor))) {
						queue.offer(neighbor);
						visited.add(neighbor);
						result.add(neighbor);
					}
				}
			}
		}
		return result;
	}

	private String getDomainFromURL(String startUrl) {
		String[] temp = startUrl.split("://");
		if (temp[1].contains("/"))
			return temp[1].substring(0, temp[1].indexOf('/'));
		return temp[1];
	}

	class HtmlParser {
		List<String> getUrls(String url) {
			return null;
		}
	}

}
