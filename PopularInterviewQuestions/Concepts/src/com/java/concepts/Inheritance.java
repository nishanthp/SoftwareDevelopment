package com.java.concepts;

public class Inheritance {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		b.thisIsPublic();
		//b.thisisPrivate(); you cannot do this. private functions are not accessible.
		B.thisIsStatic();
		A.InnerA.thisIsStatic();
		A.InnerANonStatic nonStatic = a.new InnerANonStatic();
		nonStatic.thisIsPublic();
	}	
}

// Only public methods is overridden, not private or static ones in java. 
// private method defined in A cannot be overridden by B as it is not accessible.

class A {
	A(){
		
	}
	public void thisIsPublic() {
		System.out.println("thisIsPublic in A");
	}
	
	private void thisIsPrivate() {
		System.out.println("thisIsPrivate in A");
	}
	
	public static void thisIsStatic() {
		System.out.println("thisIsStatic in A");
	}
	
	static class InnerA extends A{
	}
	
	class InnerANonStatic extends A{
	}
}

class B extends A{
	B(){
		
	}
	@Override
	public void thisIsPublic() {
		System.out.println("thisIsPublic in B");
	}
	// @Override - NOT AN OVERRIDE.
	private void thisIsPrivate() {
		System.out.println("thisIsPrivate in B");
	}
	// @Override - NOT AN OVERRIDE.
	public static void thisIsStatic() {
		System.out.println("thisIsStatic in B");
	}
}

