package accpetedSubmissions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {

	public static void main(String[] args) {
		// Ran on leetcode.
        
	}
	
	 HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	    public List<String> wordBreak(String s, List<String> wordDict) {
			return wordBreak(s, wordDict, 0);
		}
	    
	    
	    public List<String> wordBreak(String s, List<String> wordDict, Integer startIndex){
	        if(map.containsKey(startIndex)) return map.get(startIndex);
	        
	        List<String> result = new ArrayList<String>();
	        
	        if(startIndex == s.length()){
	            result.add("");
	            return result;
	        } 
	        
	        for(int i=startIndex+1; i<=s.length();i++){
	            if(wordDict.contains(s.substring(startIndex, i))){
	                List<String> list = wordBreak(s, wordDict, i);
	                for(String validString : list){
	                    result.add(s.substring(startIndex, i) + (validString == "" ? "": " ") + validString);
	                }
	            }
	            
	        }
	        map.put(startIndex, result);
	        return result;
	    }

}
