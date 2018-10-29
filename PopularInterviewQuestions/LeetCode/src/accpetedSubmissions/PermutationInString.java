package accpetedSubmissions;

public class PermutationInString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// This could have been implemented with a hashmap or a hashSet too.
	 public boolean checkInclusion(String s1, String s2) {
	        int l1 = s1.length();
	        int l2 = s2.length();
	        if(l1>l2) return false;
	        int[] map = new int[26];
	        for(int i=0;i<l1;i++){
	            map[s1.charAt(i)- 'a']=+1;
	            map[s2.charAt(i)- 'a']=-1;
	        }
	        if (IsMapZero(map)) return true;
	        for(int i=l1;i<l2;i++){
	            map[s2.charAt(i)- 'a']++;
	            // this is the important part. 
	            map[s2.charAt(i-l1) - 'a']--;
	            if(IsMapZero(map)) return true;
	        }
	        
	        return false;
	    }
	     public boolean IsMapZero(int[] input){
	         for(int i=0;i<input.length;i++){
	             if(input[i] != 0) return false;
	         }
	         return true;
	     }

}
