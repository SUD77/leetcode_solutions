/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
		ListNode fast = head;
		while (true) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode rev=slow.next;
		
		ListNode RLL=null;
		
		while(rev!=null){
			ListNode temp=rev.next;
			rev.next=RLL;
			RLL=rev;
			rev=temp;
		}
		
		slow.next=RLL;
		
		slow=slow.next;
		
		ListNode dummy=head;
		//boolean result= true;
		
		while(slow!=null){
			if(dummy.val!=slow.val){
				return false;
			}
			dummy=dummy.next;
			slow=slow.next;
		}
		
		
		return true;
    }
}