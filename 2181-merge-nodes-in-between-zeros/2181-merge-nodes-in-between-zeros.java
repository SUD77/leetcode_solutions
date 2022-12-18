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
    public ListNode mergeNodes(ListNode head) {
        
        int sum=0;
        ListNode res=head;
        
        ListNode temp=head;
        
        ListNode prev=new ListNode();
        prev.next=temp;
        
        head=head.next;
        
        while(head!=null){
            
            if(head.val==0){
                temp.val=sum;
                temp=temp.next;
                prev=prev.next;
                sum=0;        
            }
            
            sum+=head.val;
            
            head=head.next;
        }
        
        prev.next=null;
        
        return res;
    }
}