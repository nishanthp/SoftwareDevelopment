package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortIPAddressDemo {

	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String ip1, String ip2) {

				return IPCompare(ip1).compareTo(IPCompare(ip2));
			}
		};

		TreeSet<String> orderedSet = new TreeSet<>(comparator);
		orderedSet.addAll(Arrays.asList("10.10.25.124", "10.10.27.126", "127.0.0.1", "9.9.9.9"));

		for (String set : orderedSet) {
			System.out.println(set);
		}

	}

	public static Long IPCompare(String input) {
		Scanner sc = new Scanner(input);
		Scanner temp = sc.useDelimiter("\\.");
		Long value = (temp.nextLong() << 24) + (temp.nextLong() << 16) + (temp.nextLong() << 8) + (temp.nextLong());
		return value;
	}
}
