package com.accpeted.submissions;


public class NextGreaterElement3 {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
    public int nextGreaterElement(int n) {
        String input = String.valueOf(n);
        char[] inputArr = input.toCharArray();
        int i= inputArr.length-2;
        while(i >= 0 && inputArr[i] >= inputArr[i+1]){
            i--;
        }
        if(i < 0) return -1;
        int j = inputArr.length-1;
        while(j >=0 && inputArr[j] <= inputArr[i]) {
            j--;
        }
        if(j<0) return -1;
        swap(i, j, inputArr);
        reverse(inputArr, i+1);
        int maxVal=0;
        try {
              maxVal = Integer.valueOf(new String(inputArr));
        }
        catch(Exception e){
            return -1;
        }
        return maxVal;
    }
    
    public void swap(int i, int j, char[] input) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
     public void reverse(char[] input, int start) {
        int end = input.length-1;
        while(start < end) {
            swap(start, end, input);
            start++;
            end--; 
    }
}

}
