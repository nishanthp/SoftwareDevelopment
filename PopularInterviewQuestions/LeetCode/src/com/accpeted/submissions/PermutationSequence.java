package com.accpeted.submissions;

public class PermutationSequence {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	int runk = 0;
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        for(int i=1;i<=n;i++){
            s.append(i);
        }
        String in = new String(s);
        return getPermutation("", in, k); 
    }
     public String getPermutation(String prefix, String input, int k) {
         if(input.length() == 0){
             runk +=1;
             return prefix;
         }
         for(int i=0;i<input.length();i++){
             String temp = input.substring(0,i) + input.substring(i+1);
             String rtValue = getPermutation(prefix+input.charAt(i), temp, k);
             if(runk == k) return rtValue;
         }
         return prefix;
     }

}
