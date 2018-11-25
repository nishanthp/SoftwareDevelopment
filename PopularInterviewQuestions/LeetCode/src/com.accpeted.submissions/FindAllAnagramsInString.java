package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// this is a template for all *****substring/sliding window******* problems.
	public List<Integer> findAnagrams(String s, String p) {
	     List<Integer> result = new LinkedList<Integer>();
	     int pl = p.length();
	     int sl = s.length();
	     int[] hash = new int[256];
	     // build the hash with the smaller string.
	     for(int i=0;i<pl;i++){
	         hash[p.charAt(i)]++;
	     }
	     
	     int count = pl;
	     int left =0;
	     int right =0;
	     // left and right is the window. Always move right and when it hits the window size,
	     // increment left.
	     while(right < s.length()){
	         if(hash[s.charAt(right++)]-- >= 1) count--;
	         if(count == 0) result.add(left);
	         if(right-left == pl && hash[s.charAt(left++)]++ >=0) count++;
	     }
	        return result;
	}

}
