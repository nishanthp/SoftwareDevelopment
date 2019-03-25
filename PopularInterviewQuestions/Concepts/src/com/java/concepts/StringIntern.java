package com.java.concepts;

public class StringIntern {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc"; // This is already intern(ed) by the java compiler. 
		String s3 = new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		// Allocating memory for only unique strings.
		System.out.println(s1==s3.intern());

	}

}
