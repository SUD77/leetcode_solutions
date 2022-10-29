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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode res=new ListNode();
        ListNode finalAns=res;
        
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> {
            return b.val-a.val;
        });
        
        PriorityQueue<Integer> elePq=new PriorityQueue<>();
        
        for(ListNode x:lists){
            if(x!=null)
                pq.offer(x);
            
        }
        
        while(pq.size()>0){
            ListNode curr=pq.poll();
            elePq.offer(curr.val);
            
            if(curr.next!=null){
                pq.offer(curr.next);
            }
        
        }
        
        while(elePq.size()>0){
            
            ListNode temp=new ListNode(elePq.poll());
            res.next=temp;
            res=res.next;
        }
        
        
        
        
        return finalAns.next; 
        
    }
}