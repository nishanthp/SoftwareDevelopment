package com.java.concepts;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueD {

	public static void main(String[] args) {
		// offer: adds
		// peek: head of head, does not remove it
		// poll: removes head of heap.
		// by default min head. Pass comparator to make it maxHeap.
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		minHeap.offer(10);
		minHeap.offer(-2);
		minHeap.offer(33);
		minHeap.offer(0);
		System.out.println(minHeap.peek());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.peek());
		
		//maxHeap
		PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		maxHeap.offer(10);
		maxHeap.offer(-2);
		maxHeap.offer(33);
		maxHeap.offer(0);
		System.out.println(maxHeap.peek());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.peek());
	}

}
