package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

	static List<String> validWords = new ArrayList<String>();
	public static void main(String[] args) {
		// Ran on leetcode.
		
		HashSet<String> dict = new HashSet<String>();
		dict.add("to");
		dict.add("get");
		//set.add("her");
		
		String s = "together";
		System.out.println(wordBreak(dict, s));
		System.out.println(validWords.size());
	}

	private static boolean wordBreak(HashSet<String> dict, String s) {
		boolean [] dp = new boolean [s.length()+1];
		dp[0] = true;
		
		for(int i=1;i<=s.length();i++){
			for(int j=0;j<i;j++){
				if(dp[j] && dict.contains(s.substring(j, i))){
					dp[i] = true;
					validWords.add(s.substring(j, i));
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
