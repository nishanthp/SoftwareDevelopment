package com.common.templates;

import java.util.PriorityQueue;

public class TwoHeaps {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		
		int[] input = {1,2, 3,4};
		
		int result = findMedian(input, minHeap, maxHeap);
		System.out.println(result);
	}

	private static int findMedian(int[] input, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		for(int each : input) {
			maxHeap.offer(each);
			minHeap.offer(maxHeap.poll());
			if(maxHeap.size() <= minHeap.size()) maxHeap.offer(minHeap.poll());
		}
		
		if(minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek())/2;
		return maxHeap.peek();
	}

}