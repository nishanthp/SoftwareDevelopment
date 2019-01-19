package com.accpeted.submissions;

public class Read4Given42 {

	public static void main(String[] args) {
		//Ran on leetcode

	}
	
	int prevIndex = 0;
    int prevSize = 0;
    char[] temp= new char[4];
    public int read(char[] buf, int n) {
        int counter = 0;
       while(counter < n){
           if (prevIndex < prevSize) {
             buf[counter++] = temp[prevIndex++];
        } else {
            prevSize = read4(temp);
            if(prevSize == 0) break;
            prevIndex = 0;
        }
       } 
        return counter;
    }
  
    private int read4(char[] temp) {
		// Leetcode API.
		return 0;
	}

}
