package com.java.concepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

public class TwoObjectComp {

	public static void main(String[] args) {
		
		// String compare. 
		String s5 = "abc";
		String s6 = "abc";
		/* This is true. This is a complier optimization. 
		checks both the strings have the same value so uses one string object. 
		It is safe as the strings are immutable. Name 'string pool' comes from the idea that all already 
		defined string(s) are stored in some 'pool' and 
		before creating new String object compiler checks if such string is already defined.*/
		System.out.println(s5==s6);
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		// This is false. References are being compared, so they are not same.
		System.out.println(s3 == s4);
		//This is true.
		System.out.println(s3.equals(s4));
		
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 3);
		
		System.out.println(p1.equals(p2));
		
		String s = "fef"+ 'c';
		System.out.println(s);
		
		// Below are unicode characters(Super set of ascii and ascii extended).
		// Could come up during string related interview questions.
		String unicode1 = "\ud684";
		String unicode2 = "\ud800\udc35";
		System.out.println(unicode1);
		System.out.println(unicode2);
		
		HashSet<Point> s1 = new HashSet<Point>();
		s1.add(p1);
		s1.add(p2);

		System.out.println(s1.contains(new Point(2,3)));
		
		System.out.println(p1.equals(p2));
		
		ArrayList<Point>  wew = new ArrayList<Point>();
		wew.add(p1);
		System.out.println(wew.contains(new Point(2,3)));
		
	}
	

}



class Point {
	int r;
	int c;
	Point(int r, int c){
		this.c = c;
		this.r =r;
	}
	// Compare two objects using the below objects. Used by hashmap too.
	@Override
	 public boolean equals(Object point) {
		Point p = (Point) point;
		return this.r == p.r && this.c == p.c;
	}
	// Used by the hashMap data structure to put different objects within the same key.
	@Override 
	public int hashCode(){
		return r*c;
		
	}
}
