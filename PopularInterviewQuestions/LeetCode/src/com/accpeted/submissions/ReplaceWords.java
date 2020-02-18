package com.accpeted.submissions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String replaceWords(List<String> dict, String sentence) {
        Set<String> hdict = new HashSet<String>(dict);
        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        boolean rootAvailable = false;
        for(String word : words){
            for(int i=1;i<word.length();i++){
                if(hdict.contains(word.substring(0,i))) {
                    sb.append(word.substring(0,i)).append(" ");
                    rootAvailable = true;
                    break;
                }
            }
            if(!rootAvailable) sb.append(word).append(" ");
            rootAvailable = false;
        }
        return sb.toString().trim();
    }

}
