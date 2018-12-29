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

	}

}
