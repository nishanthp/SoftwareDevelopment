package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

// This is one of the problems that you need to know. 
// Use two heaps, min and max. min to track the min of all the highest elements.
// max to track the max of all the minimum elements.
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                return n2.compareTo(n1);
            }
        });
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        // below line is the key. take an example : [2,4,100]
        if(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) return (double)(minHeap.peek() + maxHeap.peek())/2;
        else return maxHeap.peek();
    }
}