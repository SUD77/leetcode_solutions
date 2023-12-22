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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head1=list1;
        ListNode head2=list2;
        ListNode temp=new ListNode(0);
        ListNode ans=temp;
        
        while(head1!=null && head2!=null){
            
            if(head1.val <=head2.val){
                ListNode newEle=new ListNode(head1.val);
                temp.next=newEle;
                temp=temp.next;
                head1=head1.next;
            }else{
                ListNode newEle=new ListNode(head2.val);
                temp.next=newEle;
                temp=temp.next;
                head2=head2.next;
            }
            
        }
        
        while(head1!=null){
            ListNode newEle=new ListNode(head1.val);
            temp.next=newEle;
            temp=temp.next;
            head1=head1.next;
        }
        
        while(head2!=null){
            ListNode newEle=new ListNode(head2.val);
            temp.next=newEle;
            temp=temp.next;
            head2=head2.next;
        }
        
        
        return ans.next;
    }
}