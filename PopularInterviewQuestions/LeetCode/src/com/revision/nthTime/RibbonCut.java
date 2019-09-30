package com.revision.nthTime;

import java.util.ArrayList;
import java.util.List;

public class RibbonCut {

	static List<List<Integer>> res = new ArrayList<>();
	static List<Integer> temp1 = new ArrayList<>();
	public static void main(String[] args) {
		int[] ribbonLengths = {2,3,4};
		countRibbonPieces(ribbonLengths, 0);
		for(List<Integer> res : res) {
			for(Integer i : res) {
				System.out.print(i);
			}
			System.out.println("");
		}

	}
	
	// Another way to do combination sum.
	 public static void countRibbonPieces(int[] ribbonLengths, int index) {
		 if(temp1.size() == ribbonLengths.length) {
			 List<Integer> temp = new ArrayList<>();
			 temp.addAll(temp1);
			 res.add(temp);
			 return;
		 }
		 if(index > ribbonLengths.length-1) return;
		 temp1.add(ribbonLengths[index]);
		 countRibbonPieces(ribbonLengths,  index);
		 temp1.remove(temp1.size()-1);
		 countRibbonPieces(ribbonLengths, index+1);
		 return;
	}

}
