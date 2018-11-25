package accpetedSubmissions;

public class FindTheDifference {

	public static void main(String[] args) {
		// Ran on leetcode.
		
	}
	
	// Keep in mind, the interconversion on int and char is an important concept.
	 public char findTheDifference(String s, String t) {
	        char charAdded ='\0'; 
	        for(int i=0;i<s.length(); i++){
	             charAdded ^= s.charAt(i); 
	        }
	        for(int i=0;i<t.length(); i++){
	            charAdded ^= t.charAt(i); 
	        }
	        return charAdded;
	        }

	
}
