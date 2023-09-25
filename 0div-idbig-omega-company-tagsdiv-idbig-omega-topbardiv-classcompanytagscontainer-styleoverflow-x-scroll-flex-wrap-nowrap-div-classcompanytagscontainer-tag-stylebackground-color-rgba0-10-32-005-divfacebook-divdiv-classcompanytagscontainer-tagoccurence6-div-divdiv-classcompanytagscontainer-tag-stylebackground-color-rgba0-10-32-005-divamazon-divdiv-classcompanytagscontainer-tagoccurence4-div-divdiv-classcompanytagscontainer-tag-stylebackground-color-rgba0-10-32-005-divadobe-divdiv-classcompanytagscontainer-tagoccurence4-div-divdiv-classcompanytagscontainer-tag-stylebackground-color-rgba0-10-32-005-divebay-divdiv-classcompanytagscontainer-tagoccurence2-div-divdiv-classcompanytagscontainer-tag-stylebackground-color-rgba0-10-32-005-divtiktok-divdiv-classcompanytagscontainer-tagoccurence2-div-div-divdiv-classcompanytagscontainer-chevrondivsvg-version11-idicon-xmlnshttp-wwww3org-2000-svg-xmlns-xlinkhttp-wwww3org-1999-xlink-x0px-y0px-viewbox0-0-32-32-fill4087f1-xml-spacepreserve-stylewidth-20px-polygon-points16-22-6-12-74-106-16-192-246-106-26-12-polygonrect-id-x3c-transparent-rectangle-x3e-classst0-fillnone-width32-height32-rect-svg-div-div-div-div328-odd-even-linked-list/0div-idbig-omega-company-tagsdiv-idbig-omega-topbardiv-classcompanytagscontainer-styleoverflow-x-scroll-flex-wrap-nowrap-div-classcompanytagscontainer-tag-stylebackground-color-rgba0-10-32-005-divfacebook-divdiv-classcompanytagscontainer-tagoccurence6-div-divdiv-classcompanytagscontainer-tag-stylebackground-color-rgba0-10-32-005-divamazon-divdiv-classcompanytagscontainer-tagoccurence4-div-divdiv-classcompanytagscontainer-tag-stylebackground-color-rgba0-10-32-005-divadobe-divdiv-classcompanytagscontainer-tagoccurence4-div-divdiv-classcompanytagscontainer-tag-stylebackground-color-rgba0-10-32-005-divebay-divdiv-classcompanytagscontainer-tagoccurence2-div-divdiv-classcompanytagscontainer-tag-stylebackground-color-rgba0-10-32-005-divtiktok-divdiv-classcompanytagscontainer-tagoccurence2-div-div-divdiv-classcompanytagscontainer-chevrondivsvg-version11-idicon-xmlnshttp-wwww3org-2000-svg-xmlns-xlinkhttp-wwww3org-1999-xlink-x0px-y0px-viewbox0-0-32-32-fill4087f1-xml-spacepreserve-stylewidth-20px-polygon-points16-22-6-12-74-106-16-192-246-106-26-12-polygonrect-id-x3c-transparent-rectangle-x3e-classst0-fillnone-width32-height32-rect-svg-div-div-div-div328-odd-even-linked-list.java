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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddList=new ListNode();
        ListNode evenList=new ListNode();
        
        ListNode dummy1=oddList;
        ListNode dummy2=evenList;
        
        int count=1;
        while(head!=null){
            
            ListNode temp=new ListNode(head.val);
            if(count%2==0){
                evenList.next=temp;
                evenList=evenList.next;
            }else{
                oddList.next=temp;
                oddList=oddList.next;
            }
            
            head=head.next;
            count++;
        }
        
        
        // System.out.println(oddList.val);
        oddList.next=dummy2.next;
        // dummy2.next=null;
        
        return dummy1.next;
        
    }
}