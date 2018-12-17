package com.accpeted.submissions;

public class SimpleRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		System.out.println(recurssionWithVar(i));
		int[] array = new int[10];
		recurssionWithArray(array, i);
		for (int each : array) {
			System.out.println(each);
		}
	}

	public static int recurssionWithVar(int i) {
		if (i >= 10)
			return i;
		i += 1;
		i = recurssionWithVar(i);
		return i;
	}

	public static int[] recurssionWithArray(int[] array, int i) {
		if (i >= 10)
			return array;
		array[i] = i;
		i += 1;
		recurssionWithArray(array, i);
		return array;
	}
}
