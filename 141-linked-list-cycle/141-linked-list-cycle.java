/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode first=head;
        ListNode second=head;
        
        if(head==null) return false;
        // if(head.next==null || head.next.next==null) return false;
        // if(head.next==head) return true;
        
        while(first.next!=null && first.next.next!=null){
            
            
            first=first.next.next;
            second=second.next;
            
            if(first==second) {
                return true;
            }
            
            
            
                
        }
        
        return false;
    }
}