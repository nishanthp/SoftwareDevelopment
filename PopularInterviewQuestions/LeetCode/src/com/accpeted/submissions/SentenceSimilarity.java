package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SentenceSimilarity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null && words2 == null) return true;
        if (words1 == null || words2 == null) return false;
        if(words1.length != words2.length) return false;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String [] pair : pairs){
            List<String> temp = map.getOrDefault(pair[0], new LinkedList<String>());
            temp.add(pair[1]);
            map.put(pair[0], temp);
        }
        for(int i=0;i<words1.length;i++){
            if(!words1[i].equals(words2[i])) {
                List<String> t1 = map.getOrDefault(words1[i], null);
                List<String> t2 = map.getOrDefault(words2[i], null);
                if(t1 == null && t2 == null) return false;
                if (t1 == null || !t1.contains(words2[i])){
                if (t2 == null || !t2.contains(words1[i])) return false;
                }
            }
        }
        return true;
    }

}
