package com.accpeted.submissions;

public class StringCompression {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public int compress(char[] chars) { 
        int indexAns = 0;
        int index=0;
        while(index < chars.length){  
            char currChar = chars[index];
               if (currChar == chars[index]){
                  int counter = 0;
                  while(index< chars.length && currChar == chars[index]) {
                    counter+=1;
                    index+=1;
                }
                   chars[indexAns++] = currChar;
                   if (counter != 1) {
                      for (char c : Integer.toString(counter).toCharArray() ){
                          chars[indexAns++] = c;
                      }
                   }
               } 
        }
        return indexAns;
    }

}
