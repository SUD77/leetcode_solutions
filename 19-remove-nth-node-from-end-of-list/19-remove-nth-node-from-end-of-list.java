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
        
        ListNode Rll=reverseList(head);
        
        int count=1;
        ListNode temp=new ListNode(0);
        temp.next=Rll;
        
        ListNode dummy=temp;
        
        while(Rll!=null){
            
            if(count==n){
                temp.next=Rll.next;
            }
            
            count++;
            temp=temp.next;
            Rll=Rll.next;
        }
        
        ListNode result=reverseList(dummy.next);
        
        return result;
    }
    
    public ListNode reverseList(ListNode head){
        
        ListNode Rll=null;
        
        while(head!=null){
            ListNode temp=head.next;
            head.next=Rll;
            Rll=head;
            head=temp;
            
        }
        
        return Rll;
    }
}