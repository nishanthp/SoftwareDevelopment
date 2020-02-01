package com.java.concepts;

import java.util.HashMap;

public class HashCodeCollusion {

	public static void main(String[] args) {
		// Example of collision. uncomment the equals method see the wrong
		// results.
		Object12 obj = new Object12();
		Object22 obj2 = new Object22();
		HashMap<Object, Integer> map = new HashMap<>();
		map.put(obj, 1);
		map.put(obj2, 2);
		// If two objects fall within the same bucket, hashMap uses .equals()
		// method to fetch the appropriate object. In the above case obj and
		// obj2 are same. So the below line should always give the answer as 2.
		System.out.println(map.get(obj));
	}

}

class Object12 {
	int n = 1;
	@Override
	public int hashCode() {
		return 1;

	}
	@Override
	public boolean equals(Object o) {
		return n == 1;
	}
}

class Object22 {
	int n = 1;
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object o) {
		return n == 1;
	}
}