package accpetedSubmissions;

public class PalindromeLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null && fast.next == null)
			slow = slow.next;
		slow = reverseRightPart(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	public ListNode reverseRightPart(ListNode newhead) {
		ListNode prev = null;
		while (newhead != null) {
			ListNode next = newhead.next;
			newhead.next = prev;
			prev = newhead;
			newhead = next;
		}
		return prev;
	}
}
