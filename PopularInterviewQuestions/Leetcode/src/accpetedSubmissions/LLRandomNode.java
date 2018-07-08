package accpetedSubmissions;

import java.util.Random;

public class LLRandomNode {

	public static void main(String[] args) {
		// TODO Ran on leetcode.
	}

	ListNode head;
    Random r;
    int result;
    public LLRandomNode(ListNode head) {
        this.head = head;
        r = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = this.head;
        result = curr.val;
        for(int i = 1; curr.next != null; i++){
            curr = curr.next;
            if(r.nextInt(i+1) == i) result = curr.val;
        }
        return result;
    }
}
