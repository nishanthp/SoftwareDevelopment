package com.accpeted.submissions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();       
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tString = new String(temp);
            if (map.containsKey(tString)){
                map.get(tString).add(s);
            }else{
                List<String> t = new LinkedList<String>();
                t.add(s);
                map.put(new String(temp), t);
            }
}
        result.addAll(map.values());
        return result;
    }

}
