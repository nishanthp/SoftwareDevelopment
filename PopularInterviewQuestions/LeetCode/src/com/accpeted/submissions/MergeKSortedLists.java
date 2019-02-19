package com.accpeted.submissions;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ListNode dummyNode = new ListNode(0);
        for(int i=0;i<lists.length;i++){
            ListNode head = lists[i];
            while(head != null) {
                minHeap.add(head.val); 
                head = head.next;
            }
        }
        ListNode result = dummyNode;
        while(minHeap.size() > 0){
            ListNode temp = new ListNode(minHeap.poll());
            result.next =  temp;
            result = temp;
        }
        return dummyNode.next;
    }

}
