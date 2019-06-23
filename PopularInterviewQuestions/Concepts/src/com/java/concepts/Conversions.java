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
		
		int numReq = 144;
		String numReqStr = String.valueOf(numReq);
		System.out.println(numReqStr);
		
		// This is important.
		int n1 = 3;
		char  ch1 = Character.forDigit(n1,10);
		System.out.println(ch1);
		
		// This could be done too. If you pass just the object, it throws the address of
		// the object back.
		M m = new M();
		String s = String.valueOf(m.s);
		System.out.println(":"+ s);
		
		// This is auto boxing.
		char ch2 = Character.valueOf('1');		
		System.out.println(ch2);

		// Values are from 10 to 35.
		// ASCII has a mapping of 128 chars. 0-127.
		// Unicode is a superset of ASCII from 0-2^21.
		int val = Character.getNumericValue('A');
		System.out.println("val "+val);
		

	}

}

class M {
	String s = "afwef";
}
