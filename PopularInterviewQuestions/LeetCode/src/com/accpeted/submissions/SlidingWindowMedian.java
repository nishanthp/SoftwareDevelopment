package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return new double[0];
        int size = nums.length-k;
        double[] medians = new double[size+1];
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(new Comparator<Double>(){
            @Override 
            public int compare(Double n1, Double n2){
                return n2.compareTo(n1);
            }
        });
        int left = 0;
        int right = 0;
        int counter = k;
        while(right < nums.length) {       
            maxHeap.offer((double)nums[right]);
            minHeap.offer(maxHeap.poll());
            if(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll()); 
            right++;
            counter--;
            while(counter == 0) {
                System.out.println(right);
                double currMedian = 0.0;
                if(minHeap.size() == maxHeap.size()) {
                    currMedian = (minHeap.peek() + maxHeap.peek())/2.0;
                    System.out.println("here");
                } else {
                    currMedian = maxHeap.peek();
                }
                medians[left] = currMedian;
                // below is the important part.
                if(!maxHeap.remove((double)nums[left])) {
                     minHeap.remove((double)nums[left]);
                }
                left++;
                counter ++;
            }
        }
        return medians;
    }

}
