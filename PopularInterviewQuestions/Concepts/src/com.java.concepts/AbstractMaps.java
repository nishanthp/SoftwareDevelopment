package javaConcepts;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AbstractMaps {

	public static void main(String[] args) {		
		// Array of linkedlist, O(1), lookup and insertion
		HashMap<Integer, Integer> keysNotOrdered = new HashMap<>();
		//doubly linked buckets, O(1), lookup and insertion
		LinkedHashMap<Integer, Integer> keysInsertionOrder = new LinkedHashMap<>();
		//Red-black tree O(log n), lookup and insertion
		TreeMap<Integer, Integer> keysSortedOrder = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(-2);
		list.add(4);
		list.add(0);
		
		//insert.
		for(Integer each : list){
			keysNotOrdered.put(each, each);
			keysInsertionOrder.put(each, each);
			keysSortedOrder.put(each, each);
		}
		
		//print keysNotOrdered.
		for(Entry<Integer, Integer> entry : keysNotOrdered.entrySet()){
			System.out.print(entry.getKey());
			//System.out.println(entry.getValue());
		}
		System.out.println();
		for(Entry<Integer, Integer> entry : keysInsertionOrder.entrySet()){
			System.out.print(entry.getKey());
			//System.out.println(entry.getValue());
		}
		System.out.println();
		for(Entry<Integer, Integer> entry : keysSortedOrder.entrySet()){
			System.out.print(entry.getKey());
			//System.out.println(entry.getValue());
		}
		System.out.println();
		//getOrDefault
		System.out.println(keysNotOrdered.getOrDefault(1, Integer.MAX_VALUE));
		System.out.println(keysNotOrdered.getOrDefault(100, Integer.MAX_VALUE));
	} 
	
	

}
