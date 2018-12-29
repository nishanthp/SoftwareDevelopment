package com.accpeted.submissions;

import java.util.HashMap;

public class CopyListRandomPointer {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode cDummy = dummyHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        while(curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            cDummy.next = temp;
            map.put(curr, temp);
            curr = curr.next;
            cDummy = temp;
        }
        RandomListNode p = head;
        
        while(p != null) {
            if (p.random != null) {
                RandomListNode clonedNode = map.get(p);
                RandomListNode target = map.get(p.random);
                clonedNode.random = target;
            }
            p = p.next;
        }        
        return dummyHead.next;
        
    }

}

class RandomListNode {
	int label;
	RandomListNode(int value){
		this.label = value;
	}
	RandomListNode next, random;
}
