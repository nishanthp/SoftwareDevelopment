package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortCharByFreq {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       StringBuilder builder = new StringBuilder();
        for(Character ch : s.toCharArray()){
            if(!map.containsKey(ch)) map.put(ch, 1);
            else {
                map.put(ch, map.get(ch)+1);
                
            }
        }
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>(new ComparCh(map));
        treeMap.putAll(map);
        for(Map.Entry<Character, Integer> entry : treeMap.entrySet()){
            int count = entry.getValue();
            while(count > 0) {
                builder.append(entry.getKey()+"");
                count -=1;
            }
        }
        return builder.toString();
    }
}

class ComparCh implements Comparator<Character>{

	HashMap<Character,Integer> map;
	ComparCh(HashMap<Character,Integer> map){
	this.map = map;
}

@Override
public int compare(Character o1, Character o2) {
    
	// This is the most important part. Without line number 50 and 51, it wont work for tie braker, i.e if the values are same.
	int ret = this.map.get(o2).compareTo(this.map.get(o1));
    if (ret != 0) return ret;
    else return o1.compareTo(o2);
}


}
