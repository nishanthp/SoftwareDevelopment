package com.accpeted.submissions;

import java.util.PriorityQueue;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// Ran on leetcode

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(l1 != null){
            minHeap.add(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            minHeap.add(l2.val);
            l2 = l2.next;
        }
        
        while(minHeap.size() > 0){
            ListNode temp = new ListNode(minHeap.poll());
            result.next = temp;
            result = temp;
        }
        return dummy.next;
    }

}
