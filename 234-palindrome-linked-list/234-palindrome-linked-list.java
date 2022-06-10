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
        
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        
        ListNode rev=slow.next;
        
        ListNode Rll=null;
            
        //Reversing the list here
        while(rev!=null){
            ListNode temp=rev.next;
            rev.next=Rll;
            Rll=rev;
            rev=temp;
        }
        
        ListNode dummy=head;
        
        while(Rll!=null){
            if(dummy.val!=Rll.val){
                return false;
            }
            dummy=dummy.next;
            Rll=Rll.next;
        }
        
        return true;
            
    }
}