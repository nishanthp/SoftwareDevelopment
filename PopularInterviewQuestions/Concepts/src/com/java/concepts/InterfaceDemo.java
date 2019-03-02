package com.java.concepts;

import java.util.ArrayList;

public class InterfaceDemo {
	public static void main(String[] args) {
		d1 d = new d1();
		ArrayList<Integer> d1Array = new ArrayList<>();
		d1Array.add(12);
		d.setDays(d1Array);

		d2 d1 = new d2();
		ArrayList<Integer> d2Array = new ArrayList<>();
		d2Array.add(12);
		d.setDays(d2Array);

		ArrayList<demo> year = new ArrayList<>();
		year.add(d);
		year.add(d1);
		System.out.println(d.getString());
		for (demo each : year) {
			for (Integer day : each.days) {
				System.out.println(day);
			}
		}

	}
}

interface demo {
	// they are static and final. Can access them, but cannot set them.
	ArrayList<Integer> days = new ArrayList<>();
	String s = "abc";
}

class d1 implements demo {
	ArrayList<Integer> days = new ArrayList<>();

	/**
	 * as the variables are static and final we can access them as shown below.
	 * 
	 * @return
	 */
	public ArrayList<Integer> getDays() {
		return demo.days;
	}
	
	public String getString() {
		return demo.s;
	}

	/*
	 * cannot set the interface variables as they are static and final. One of
	 * the disadvantages of an interface over an abstract class.
	 */
	public void setDays(ArrayList<Integer> days) {

		// demo.days = days;
	}
}

class d2 implements demo {
	ArrayList<Integer> days = new ArrayList<>();

	public ArrayList<Integer> getDays() {
		return days;
	}

	public void setDays(ArrayList<Integer> days) {
		this.days = days;
	}
}