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
    public ListNode removeElements(ListNode head, int val) {
        
        List<Integer> temp=new ArrayList<>();
        ListNode result=new ListNode();
        ListNode refR=result;
        
        while(head!=null){
            if(head.val!=val){
              temp.add(head.val);  
            }
            
            head=head.next;
        }
        
        for(Integer ele:temp){
            ListNode tempNode=new ListNode(ele);
            result.next=tempNode;
            result=tempNode;
        }
        
        return refR.next;
    }
}