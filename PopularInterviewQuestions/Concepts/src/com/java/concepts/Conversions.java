package com.java.concepts;

public class Conversions {

	public static void main(String[] args) {
		// int to char
		int i = 97;
		char c = (char) i;
		System.out.println(c);
		
		// char to int
		char ch = 'A';
		int num = (int) ch;
		System.out.println(num);
		
		char n = '1';
		int actualNum = Integer.valueOf(n+"");
		System.out.println(actualNum);
		
		int n1 = 3;
		char  ch1 = Character.forDigit(n1,10);
		int val = Character.getNumericValue('A');
		System.out.println("val "+val);
		System.out.println(ch1);
		
		int numReq = 144;
		System.out.println(String.valueOf(numReq));
		
		char ch2 = Character.valueOf('a');
		System.out.println(ch2);

	}

}
