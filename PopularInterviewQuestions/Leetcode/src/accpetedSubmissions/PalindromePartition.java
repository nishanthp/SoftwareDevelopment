package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Ran on leetcode.


	}
	
	 // Need to learn on how this is working.
	 List<List<String>> lists = new LinkedList<>();
	    List<String> list = new LinkedList<String>();
	    public List<List<String>> partition(String s) {
	        partition(s, 0);
	        return lists;
	    }
	    
	    
	    public void partition(String s, int start) {
	       if (start == s.length()){
	            LinkedList<String> tempList = new LinkedList<String>();
	            tempList.addAll(list);
	            lists.add(tempList);
	            return;
	        }
	        for(int i=start;i<s.length();i++){
	            if(isPalindrome(s,start,i)){
	                list.add(s.substring(start,i+1));	                
	                partition(s, i+1);
	                list.remove(list.size()-1);
	            }
	        }
	    }
	    
	    private boolean isPalindrome(String s, int start, int end){
	        while(start < end){
	            if(s.charAt(start) != s.charAt(end)) return false;
	            start+=1;
	            end-=1;
	        }
	        return true;
	    }

}
