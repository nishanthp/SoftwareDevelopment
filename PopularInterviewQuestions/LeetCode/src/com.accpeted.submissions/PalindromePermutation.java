package accpetedSubmissions;

import java.util.HashSet;

public class PalindromePermutation {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	// No need to generate all the palindrome permutations. 
	// Just check whether the number of char(s) are even and/or just one char is odd.
	public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)) set.remove(c);
            else set.add(c);           
        }
        return set.size() == 0 || set.size() == 1;
    }

}
