package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBacktracking {
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<String> listString = new ArrayList<>();
	public static void main(String[] args) {
		String s = "aab";
		int[] n = {1,2,3,4,5};
		
		//recursivebt(n, 0);
		recursivebt(s, 0);
	}
	
	
	private static void recursivebt(String input, int index) {
		if(index == input.length()) return;
		for(int i=index; i< input.length();i++){
			//System.out.print(input[index]);
			listString.add(input.substring(index, i+1));
			printListString(listString);
			recursivebt(input, index+1);
			listString.remove(listString.size() -1);
		}	
	}

	private static void recursivebt(int[] input, int index) {
		if(index== input.length) return;
		for(int i=index; i< input.length;i++){
			//System.out.print(input[index]);
			list.add(input[index]);
			printList(list);
			recursivebt(input, index+1);
			list.remove(list.size() -1);
		}	
	}
	
	public static void printListString(ArrayList<String> list){
		for(String each : list){
			System.out.print(each);
		}
		System.out.println(" ");
	}
	
	public static void printList(List<Integer> list){
		for(Integer each : list){
			System.out.print(each);
		}
		System.out.println(" ");
	}

}
