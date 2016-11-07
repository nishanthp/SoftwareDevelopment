package JavaConcepts;

public class HashCodeEqualsOverride {
	public static void main(String[] args) {
		Configuration config_1 = new Configuration();
		Configuration config_2 = new Configuration();
		config_1.name = "hashcode";
		config_2.name = "hashcode_1";
		System.out.println(config_1.hashCode());
		System.out.println(config_2.hashCode());
		if (config_1.equals(config_2)) {
			System.out.println("Is this true");
		}
	}
}

class Configuration {
	String name;
	int number;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuration other = (Configuration) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
}