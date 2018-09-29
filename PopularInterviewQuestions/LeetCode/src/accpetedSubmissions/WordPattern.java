package accpetedSubmissions;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;
        HashMap<String, Character> bijection = new HashMap<String, Character>();
        int index = 0;
        for(String eachString : strs){
            char patternChar = pattern.charAt(index);
            if(!bijection.containsKey(eachString) && bijection.containsValue(patternChar)) return false;
            if(bijection.containsKey(eachString) && !bijection.get(eachString).equals(patternChar)){   
                return false;
            }else{
                System.out.println(eachString + "  "+ patternChar);
                bijection.put(eachString, patternChar);
            }
            index +=1;
        }
        return true;
    }

}
