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
    public ListNode deleteDuplicates(ListNode head) {

        Set<Integer> s=new TreeSet<>();
        
        ListNode res=new ListNode();
        ListNode resR=res;
        
        while(head!=null){
            s.add(head.val);
            head=head.next;
        }
        
         Iterator<Integer> it=s.iterator();

        while(it.hasNext()){
            ListNode temp=new ListNode(it.next());
            res.next=temp;
            res=temp;
        }
        
        return resR.next;
        
        
    }
}