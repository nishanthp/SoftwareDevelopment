package com.epi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedNArray {

	public static void main(String[] args) {
		// Asked during Amazon interview.
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> temp1 = new ArrayList<>();
		temp1.add(1);
		temp1.add(2);
		temp1.add(3);
		
		List<Integer> temp2 = new ArrayList<>();
		temp2.add(11);
		temp2.add(12);
		temp2.add(131);
		List<Integer> temp3 = new ArrayList<>();
		temp3.add(21);
		temp3.add(22);
		temp3.add(23);
		
		lists.add(temp1);
		lists.add(temp2);
		lists.add(temp3);
		for(Integer i : mergeNArrayList(lists)) {
			System.out.println(i);
		}
		
	}
	
	public static List<Integer> mergeNArrayList(List<List<Integer>> lists) {
		PriorityQueue<IndexToVal> queue = new PriorityQueue<IndexToVal>(new Comparator<IndexToVal>() {
			@Override
			public int compare(IndexToVal i1, IndexToVal i2) {
				return i1.val - i2.val;
			}
		});
		List<Iterator<Integer>> iterators = new ArrayList<>();
		int i=0;
		for(List<Integer> list : lists) {
			Iterator<Integer> temp = list.iterator();
			iterators.add(temp);
			if(temp.hasNext()) {
				int val = temp.next();
				queue.offer(new IndexToVal(i,val));
				i++;
		}
		
	}
		List<Integer> result = new ArrayList<>();
		
		while(!queue.isEmpty()){
			IndexToVal curr = queue.poll();
			result.add(curr.val);
			Iterator<Integer> temp = iterators.get(curr.index);
			if(temp.hasNext()) {
				queue.offer(new IndexToVal(curr.index, temp.next()));
			}		
		}

		return result;
	}
}

class IndexToVal {
	int index;
	int val;
	IndexToVal(int ind, int v){
		this.index = ind;
		this.val = v;
	}
}