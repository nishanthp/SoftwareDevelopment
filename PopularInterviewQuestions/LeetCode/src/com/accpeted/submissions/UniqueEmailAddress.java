package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UniqueEmailAddress {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int numUniqueEmails(String[] emails) {
        HashMap<String, List<String>> map = new HashMap<String,List<String>>();
        for(String email : emails) {
            String[] parts = email.split("@");
            String domain = parts[1];
            String recepient = parts[0];
            recepient = recepient.replace(".", "");
            String[] reqRecp = recepient.split("\\+");
            List<String> rs = map.getOrDefault(domain, new LinkedList<String>());
            if (!rs.contains(reqRecp[0])) rs.add(reqRecp[0]);
            map.put(domain, rs);
        }
        int count = 0;
        for(List<String> list : map.values()) {
            count += list.size();
        }
        return count;
    }

}
