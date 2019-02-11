package com.epi;

public class OddEven {

	public static void main(String[] args) {
		int[] input = {1,3,4,5,6,7,8};
		//evenFirst(input);
		notBruteForceevenFirst(input);
		for(int i : input) {
			System.out.println(i);
		}
	}
	
	// this is the brute force method.
	private static void evenFirst(int[] input) {
		for(int i=0;i<input.length;i++) {
			if(input[i]%2 != 0) {
				for(int j=i+1;j<input.length;j++) {
					 if(input[j] %2 == 0) {
						 //System.out.println(i);
						 int temp = input[j];
						 input[j] = input[i];
						 input[i] = temp;
						 break;
					 }
				}
			}
		}
	}
	
	// Two pointer solution (from two ends of the array)
	private static void notBruteForceevenFirst(int[] input) {
		int evenIndex = 0;
		int oddIndex = input.length -1 ;
		while(evenIndex < oddIndex) {
			if (input[evenIndex] % 2 != 0) {
				//swap
				int temp = input[oddIndex];
				input[oddIndex] = input[evenIndex];
				input[evenIndex] = temp;
				oddIndex -=1;
			} else {
				evenIndex ++;
			}	
			
		}
	}	

}
