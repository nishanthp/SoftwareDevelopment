package accpetedSubmissions;

public class SwapNodesInPairsLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Same concept of swapping the elements and not reversing the pointers.
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
    
        while(prev.next != null && prev.next.next != null){
            ListNode curr = prev.next;
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;        
            prev = prev.next.next;
            
        }
        return dummy.next;
    }

}
