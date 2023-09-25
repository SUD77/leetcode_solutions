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
        
        while(head!=null){
            pq.add(head.val);
            head=head.next;
        }
        
        ListNode list=new ListNode();
        ListNode dummy=list;
        
        while(!pq.isEmpty()){
            ListNode temp=new ListNode(pq.poll());
            list.next=temp;
            list=list.next;
        }
        
        return dummy.next;
    }
}