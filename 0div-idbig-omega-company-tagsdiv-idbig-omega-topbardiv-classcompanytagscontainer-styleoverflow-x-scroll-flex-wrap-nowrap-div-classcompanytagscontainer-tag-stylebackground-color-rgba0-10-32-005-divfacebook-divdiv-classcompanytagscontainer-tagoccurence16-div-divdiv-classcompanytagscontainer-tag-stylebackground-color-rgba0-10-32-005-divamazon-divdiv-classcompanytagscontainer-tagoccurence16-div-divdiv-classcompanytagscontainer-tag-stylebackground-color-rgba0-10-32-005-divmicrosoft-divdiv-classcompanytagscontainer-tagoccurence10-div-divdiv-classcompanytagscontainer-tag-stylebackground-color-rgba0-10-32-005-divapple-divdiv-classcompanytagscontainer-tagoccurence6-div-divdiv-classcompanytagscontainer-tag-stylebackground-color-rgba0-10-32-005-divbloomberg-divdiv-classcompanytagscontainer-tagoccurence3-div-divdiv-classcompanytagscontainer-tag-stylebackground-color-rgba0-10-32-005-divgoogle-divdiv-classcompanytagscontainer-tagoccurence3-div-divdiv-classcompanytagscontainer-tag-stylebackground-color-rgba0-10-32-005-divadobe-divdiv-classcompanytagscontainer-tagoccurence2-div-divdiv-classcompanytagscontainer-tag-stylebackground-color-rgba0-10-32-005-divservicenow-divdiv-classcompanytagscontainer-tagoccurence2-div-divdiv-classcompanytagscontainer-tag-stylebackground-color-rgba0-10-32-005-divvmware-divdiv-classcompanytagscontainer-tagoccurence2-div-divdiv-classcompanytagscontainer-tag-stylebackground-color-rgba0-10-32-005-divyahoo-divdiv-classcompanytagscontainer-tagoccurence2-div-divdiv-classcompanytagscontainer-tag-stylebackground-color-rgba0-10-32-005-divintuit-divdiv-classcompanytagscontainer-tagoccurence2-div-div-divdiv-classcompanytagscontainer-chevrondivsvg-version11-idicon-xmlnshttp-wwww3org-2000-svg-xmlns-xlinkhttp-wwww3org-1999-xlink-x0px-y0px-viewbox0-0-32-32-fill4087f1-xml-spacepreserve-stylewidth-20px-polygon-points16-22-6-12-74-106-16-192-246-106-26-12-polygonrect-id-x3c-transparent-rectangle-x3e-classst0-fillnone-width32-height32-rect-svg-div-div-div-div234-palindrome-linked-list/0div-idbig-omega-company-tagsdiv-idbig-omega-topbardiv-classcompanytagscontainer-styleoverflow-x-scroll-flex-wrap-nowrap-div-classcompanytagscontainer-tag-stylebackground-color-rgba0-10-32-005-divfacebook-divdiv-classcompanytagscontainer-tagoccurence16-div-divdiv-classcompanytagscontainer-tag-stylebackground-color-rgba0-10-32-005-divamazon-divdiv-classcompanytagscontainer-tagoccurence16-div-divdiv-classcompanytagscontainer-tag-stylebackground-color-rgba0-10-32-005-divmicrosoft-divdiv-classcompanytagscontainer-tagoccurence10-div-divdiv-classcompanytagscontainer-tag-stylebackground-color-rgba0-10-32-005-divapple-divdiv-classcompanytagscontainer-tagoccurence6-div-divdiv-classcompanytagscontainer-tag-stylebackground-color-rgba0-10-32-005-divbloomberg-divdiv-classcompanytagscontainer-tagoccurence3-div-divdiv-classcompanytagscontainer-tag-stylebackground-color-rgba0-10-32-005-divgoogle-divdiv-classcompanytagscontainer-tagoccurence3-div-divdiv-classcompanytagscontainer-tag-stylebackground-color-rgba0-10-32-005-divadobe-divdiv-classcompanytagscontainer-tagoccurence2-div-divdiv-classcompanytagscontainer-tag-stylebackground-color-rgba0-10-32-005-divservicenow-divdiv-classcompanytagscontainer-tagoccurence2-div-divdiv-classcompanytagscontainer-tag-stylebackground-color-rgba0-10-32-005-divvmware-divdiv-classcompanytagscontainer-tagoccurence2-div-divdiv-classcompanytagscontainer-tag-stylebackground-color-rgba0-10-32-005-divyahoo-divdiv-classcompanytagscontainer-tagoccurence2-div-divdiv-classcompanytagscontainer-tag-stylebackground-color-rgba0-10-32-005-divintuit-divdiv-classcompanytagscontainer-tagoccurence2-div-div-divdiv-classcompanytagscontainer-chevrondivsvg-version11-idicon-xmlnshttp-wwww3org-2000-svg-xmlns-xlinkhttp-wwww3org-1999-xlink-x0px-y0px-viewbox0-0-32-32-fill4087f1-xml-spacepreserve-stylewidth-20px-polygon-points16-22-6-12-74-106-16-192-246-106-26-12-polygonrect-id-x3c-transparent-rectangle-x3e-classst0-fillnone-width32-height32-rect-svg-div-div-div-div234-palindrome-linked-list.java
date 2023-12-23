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
        
        
        ListNode slow=new ListNode(0);
        ListNode fast=new ListNode(0);
        
        slow.next=head;
        fast.next=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode sec=reverse(slow.next);
        
        while(sec!=null){
            if(head.val!=sec.val) return false;
            
            head=head.next;
            sec=sec.next;
        }
        
        return true;
        
    }
    
    public ListNode reverse(ListNode node){
        
        ListNode cur=node;
        ListNode prev=null;
        
        
        while(cur!=null){
            ListNode nex=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nex;
            
        }
        
        return prev;
    }
    
    
    
    
}