package accpetedSubmissions;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String reverseOnlyLetters(String S) {
        int start = 0;
        int end = S.length()-1;
        char[] sA = S.toCharArray();
        while(start < end){
            while(start< end && !isAlpabet(sA[start]))
            start++;
            while(start< end && !isAlpabet(sA[end]))
            end--;
            
            char temp = sA[start];
            sA[start] = sA[end];
            sA[end] = temp;
            start++;
            end--;      
        }
        return new String(sA);
    }
    
    
    public boolean isAlpabet(char input){
        if(input >= 'a' && input <= 'z') return true;
        else if(input >= 'A' && input <= 'Z') return true;
        return false;
    }

}
