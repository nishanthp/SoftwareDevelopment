package com.java.concepts;

/**
 * 
 * @author prakasni 
 * Usually the convention followed is T or E not a A.
 */
public class GenericMethodDemo {
	public <A> A printArray(A[] inputArray) {
		A sum = null;
		for (A input : inputArray) {
			System.out.println(input);
		}
		return sum;
	}

	public static void main(String[] args) {

		Integer i[] = { 1, 2, 3, 4 };
		String[] data = { "n", "i", "s" };

		GenericMethodDemo d = new GenericMethodDemo();
		d.printArray(i);
		d.printArray(data);
	}
}
