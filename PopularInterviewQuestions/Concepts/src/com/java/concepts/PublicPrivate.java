package com.java.concepts;

public class PublicPrivate {

	public static void main(String[] args) {
		N1 n1 = new N1();
		System.out.println(n1.getterPrivate());
		N2 n2 = new N2();
		System.out.println(n2.x);
		String s = "fefw";
		s.intern();
	}

}


abstract class N {
	
}

class N1 {
	private int thisIsPrv = 50;
	int getterPrivate(){
		// can access a private variable through a public method.
		return this.thisIsPrv;
	}
}

final class N2 {
	// non final variable in a final class.
	public int x = 8;
}