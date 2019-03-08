package com.revision.nthTime;

public class OneMonthApart {

	public static void main(String[] args) {
		// Internal transfer amazon question.
		String d1 = "05/1/19";
		String d2 = "05/12/18";
		try {
			System.out.println(oneMonthApart(d1,d2));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	private static boolean oneMonthApart(String d1, String d2) throws Exception{
		if(d1 == null || d1.length() == 0) {
			new NumberFormatException();
		}
		if(d2 == null || d2.length() == 0) {
			new NumberFormatException();
		}
		String[] input1 = d1.split("/");
		String[] input2 = d2.split("/");
		int[] in1 = convertToIntArray(input1); 
		int[] in2 = convertToIntArray(input2); 
		int yearDiff = Math.abs(in1[2] - in2[2]);
		if(yearDiff > 1) return false;
		else if (yearDiff == 1){
			if (Math.abs(in1[1] - in2[1]) != 11) return false;
			return in1[0] == in2[0] ? true:false;
		} else {
			if (Math.abs(in1[1] - in2[1]) != 1) return false;
			return in1[0] == in2[0] ? true:false;
		}
}

	private static int[] convertToIntArray(String[] input) {
		int[] res = new int[input.length];
		int index=0;
		for(String s : input) {
			res[index++]  = Integer.valueOf(s);
		}
		return res;
	}
}
