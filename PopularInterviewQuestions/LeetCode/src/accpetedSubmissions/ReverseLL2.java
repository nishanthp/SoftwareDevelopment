package accpetedSubmissions;

public class ReverseLL2 {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=0;i<m-1;i++) prev = prev.next;
        
        ListNode start = prev.next;
        ListNode next = start.next;
        
        // This is the important part.  The elements are only swapped during each iteration, instead of moving the pointers. 
        // For this type of reversal we need that dummy pointer. 
        for(int i=0;i<n-m;i++){
            start.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = start.next;
        }
        
        return dummy.next;
    }

}
