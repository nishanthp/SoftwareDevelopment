package com.accpeted.submissions;

import java.util.concurrent.ConcurrentHashMap;

public class LoggerRateLimiter {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	class Logger {
		ConcurrentHashMap<String, Integer> map;
		/** Initialize your data structure here. */
		public Logger() {
			map = new ConcurrentHashMap<String, Integer>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp,
		 * otherwise returns false. If this method returns false, the message
		 * will not be printed. The timestamp is in seconds granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (map.containsKey(message)) {
				boolean ret = timestamp - map.get(message) >= 10 ? true : false;
				if (ret)
					map.put(message, timestamp);
				return ret;
			}
			map.put(message, timestamp);
			return true;
		}

	}

}