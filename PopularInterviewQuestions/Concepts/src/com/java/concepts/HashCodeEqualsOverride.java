package com.java.concepts;

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

	}
}

class Configuration {
	String name;
	Integer number;

	@Override
	public int hashCode() {
		int prime = 31;

		return prime * number.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Configuration) {
			Configuration new_name = (Configuration) obj;
			if (new_name.number.equals(((Configuration) obj).number)) {
				return true;
			} else
				return false;

		} else
			return false;
	}
}