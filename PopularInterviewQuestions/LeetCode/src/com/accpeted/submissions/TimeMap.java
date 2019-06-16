package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
}

class TimeMap1 {
    HashMap<String, List<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap1() {
        map = new HashMap<String, List<Node>>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.putIfAbsent(key, new ArrayList<Node>());
        this.map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> values =  map.getOrDefault(key, null);
        if(values == null) return "";
        int left = 0;
        int right = values.size()-1;
        while(left < right) {
            int mid = (left+right)/2;
            if(values.get(mid).timestamp == timestamp) return values.get(mid).value;
            else if(values.get(mid).timestamp < timestamp) {
                if (values.get(mid+1).timestamp > timestamp) return values.get(mid).value;
                left = mid + 1;
            } 
            else right = mid - 1;
        }

        return values.get(left).timestamp <= timestamp ? values.get(left).value : "";
    }

    class Node {
	    String value;
	    int timestamp;
	    Node(String value, int timestamp){
	        this.value = value;
	        this.timestamp = timestamp;
	    }
	}
}

