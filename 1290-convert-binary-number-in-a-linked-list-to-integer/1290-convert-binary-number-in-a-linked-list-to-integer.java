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
    public int getDecimalValue(ListNode head) {
        
        int val1=0;
        int i=0;
        
        //reversing the linkedlist
        ListNode Rll=null;
        
        while(head!=null){
            ListNode temp=head.next;
            head.next=Rll;
            Rll=head;
            head=temp;
        }
        
        while(Rll!=null){
            val1 += Math.pow(2,i) * Rll.val;
            i++;
            Rll=Rll.next;
        }
        
        return val1;
        
    }
}