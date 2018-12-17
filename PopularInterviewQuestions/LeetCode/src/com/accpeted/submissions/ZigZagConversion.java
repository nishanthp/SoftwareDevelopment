package com.accpeted.submissions;

public class ZigZagConversion {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        String result = "";
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder("");
        }
        int index=0;
        int inc = 1;
        for(int i=0;i<s.length();i++){
        	// this is the important part. 
          if(index == 0) inc = 1;
          // how the index is manipulated to get zigzag pattern.
          if(index == numRows-1) inc = -1;
          sb[index].append(s.charAt(i));
          index +=inc;
        }
        
        for(StringBuilder se : sb){
            result += se.toString();
        }
        return result;
    }

}
