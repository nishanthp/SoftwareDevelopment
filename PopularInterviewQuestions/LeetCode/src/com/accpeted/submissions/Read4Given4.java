package com.accpeted.submissions;

public class Read4Given4 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int read(char[] buf, int n) {
        boolean end = false;
        int total = 0;
        char[] temp = new char[4];
        while(!end && total < n) {      
           int count = read4(temp);
            if (count < 4) end = true;
            count = Math.min(count, n-total);
            for(int i=0;i<count;i++){
                buf[total++] = temp[i];
            }
        }
        return total;
    }

	private int read4(char[] temp) {
		// Leetcode API.
		return 0;
	}

}
