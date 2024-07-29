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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // if(n==1 && head.next==null) return head.next;
        
        ListNode dummy=new ListNode(0);
        ListNode fast=dummy;
        ListNode slow=dummy;
        
        
        dummy.next=head;
        
        
        while(n!=0){
            fast=fast.next;
            n--;
        }
        
      
        
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next=slow.next.next;
        
        
        
        return dummy.next;
        
        
    }
}