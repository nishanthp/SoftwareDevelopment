package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

	static List<String> validWords = new ArrayList<String>();
	public static void main(String[] args) {
		// Ran on leetcode.
		
		HashSet<String> set = new HashSet<String>();
		set.add("to");
		set.add("get");
		//set.add("her");
		
		String s = "together";
		System.out.println(wordBreak(set, s));
		System.out.println(validWords.size());
	}

	private static boolean wordBreak(HashSet<String> set, String s) {
		boolean [] dp = new boolean [s.length()+1];
		dp[0] = true;
		
		for(int i=1;i<=s.length();i++){
			for(int j=0;j<i;j++){
				if(dp[j] && set.contains(s.substring(j, i))){
					dp[i] = true;
					validWords.add(s.substring(j, i));
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
