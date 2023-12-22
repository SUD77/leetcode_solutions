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
        
        //if(head.next==null) return null;
            
        // nth from end is kth node from start. Need to calculate after finding length of 
        int k=0;
        
        //length of 
        int len=0;
        
        ListNode temp=head;
        
        
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        
        // System.out.println(len);
        
        
        k=len-n+1;
        
        // System.out.println("k" + k);
        
        if(k==1) return head.next;
        
        temp=head;
        int target=1;
        while(target!=k-1){
            temp=temp.next;
            target++;
        }
        
        temp.next=temp.next.next;
        
        return head;
    }
}