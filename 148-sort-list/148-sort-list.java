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
    public ListNode sortList(ListNode head) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        ListNode res=new ListNode();
        ListNode temp=new ListNode();
        
        temp.next=res;
        
        while(head!=null){
            
            pq.add(head.val);
            head=head.next;
        }
        
        
        while(!pq.isEmpty()){
            
            ListNode temp2=new ListNode(pq.poll());
            res.next=temp2;
            res=res.next;
        }
        
        return temp.next.next;
        
    }
}