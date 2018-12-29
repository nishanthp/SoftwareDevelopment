package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class CompressedStringIterator {

	public static void main(String[] args) {
		// Ran on leetcode
	}

class StringIterator {
	Queue<int[]> queue;
    public StringIterator (String compressedString) {
        queue = new LinkedList<int[]>();
       // populate the queue and check condition
        int i=0;
        int j=0;
        while(i < compressedString.length()){
            j=i+1;
            // Important point: "L10e23", here 10 or 23 is not a char. 
                                                // Here, j is incremented till we find the next character.
            while(j < compressedString.length() && compressedString.charAt(j)-'A' < 0) j++;
            queue.add(new int[]{compressedString.charAt(i),Integer.parseInt(compressedString.substring(i+1,j))});
            i=j;
        }
    }
    
    public char next() {   
        
        if(queue.isEmpty()) return ' ';
        else {
            int[] curr = queue.peek();
            if (--curr[1] == 0) {
                queue.poll();        
                }  
                return (char)curr[0];
        }
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
	
}
}
