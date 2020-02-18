package com.accpeted.submissions;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	class Codec {
		Map<String, String> shortToLong = new HashMap<String, String>();
		Map<String, String> longToShort = new HashMap<String, String>();
		int counter = 0;
		String baseUrl = "http://tinyurl.com/";
		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			if (longToShort.containsKey(longUrl)) {
				return longToShort.get(longUrl);
			}
			String shortUrl = baseUrl + String.valueOf(counter);
			longToShort.put(longUrl, shortUrl);
			shortToLong.put(shortUrl, longUrl);
			return shortUrl;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			if (shortToLong.containsKey(shortUrl))
				return shortToLong.get(shortUrl);
			return "";
		}
	}

}
