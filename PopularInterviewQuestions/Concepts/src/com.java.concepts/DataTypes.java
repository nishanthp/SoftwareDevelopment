package javaConcepts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataTypes {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1,2);
		map.put(2,3);
		map.put(3,5);
		Set<Entry<Integer, Integer>> entries = map.entrySet();
		System.out.println(entries.iterator().next());
		Set<Integer> entry = map.keySet();
		Collection<Integer> values = map.values();
		String s = "ajn";
		s.toCharArray();
//		for(Entry<Integer, Integer> entry : map.entrySet()){
//			System.out.println(entry.getValue());
//			System.out.println(entry.getKey());
//		}
		String hbs = "abcd";
		swapCharsString(hbs.toCharArray(), 0, hbs.length()-1);
		System.out.println(hbs);
		}
	
	
	public static void swapCharsString(char[] s, int start, int end){
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
	}

	}


