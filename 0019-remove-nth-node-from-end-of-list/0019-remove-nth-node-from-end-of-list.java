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
        
        if(head.next==null) return null;
        
        int l=0;
        ListNode temp=head;
        
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        
        if(l==n) return head.next;
        int k=l-n+1;
        System.out.println(k);
        
        ListNode dummy=head;
        int i=1;
        
        while(i!=k-1 ){
            head=head.next;
            i++;
        }
        
        
        System.out.println(head.val);
        
        
        head.next=head.next.next;
        
        return dummy;
    }
}