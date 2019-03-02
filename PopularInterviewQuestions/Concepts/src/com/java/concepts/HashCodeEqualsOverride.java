package com.java.concepts;

import java.util.HashMap;

public class HashCodeEqualsOverride {
	public static void main(String[] args) {
		Configuration config_1 = new Configuration();
		Configuration config_2 = new Configuration();
		config_1.name = "xyz";
		config_2.name = "abc";
		config_1.number = 1234;
		config_2.number = 1234;
		if (config_1.equals(config_2)) {
			System.out.println("They are equal");
		}
		
		HashMap<Configuration, Integer> map = new HashMap<>();
		map.putIfAbsent(config_1, 1);
		map.putIfAbsent(config_2, 1);
		System.out.println(map.size());

	}
}

class Configuration {
	String name;
	Integer number;
	
	// This is used by hashmap and hashset to store in the same bucket or not.
	@Override
	public int hashCode() {
		return 31 * number.hashCode();
	}

	// This is used to compare this object with the object which is passed in.
	// Also used by hashmap to compare the objects. If they fall in the same bucket (same hashcode)
	// .equals is used to see whether the objects are equals, if not they are stored separate elements 
	// within the same bucket.
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Configuration) {
			Configuration new_name = (Configuration) obj;
			if (new_name.number.equals(this.number)) {
				return true;
			} else
				return false;

		} else
			return false;
	}
}