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
    public ListNode detectCycle(ListNode head) {
        
        
         
        ListNode first=head;
        ListNode second=head;
        
        if(head==null) return null;
        
        while(first.next!=null && first.next.next!=null){
            
            
            first=first.next.next;
            second=second.next;
            
            if(first==second) {
             ListNode temp=head;
                while(temp!=second){
                    temp=temp.next;
                    second=second.next;
                }
                return second;
            }

        }
        
        return null;
    }
}