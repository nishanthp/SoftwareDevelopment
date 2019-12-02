package com.common.templates;

public class SlidingWindow {
	public static void main(String[] args) {
		String s = "Thisisjustatemplate";
		slidingWindow(s, 0, 0, 3);
	}

	private static void slidingWindow(String s, int left, int right,
			int counter) {
		int maxLength = Integer.MAX_VALUE;
		while (right < s.length()) {
			counter++;
			right++;
			while (counter == 0) {
				left++;
			}
			maxLength = Math.min(maxLength, right - left + 1);
		}
	}

}
