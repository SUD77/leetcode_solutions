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
        
        if(head==null || head.next==null) return head;
        ListNode t2=head.next;
        ListNode t1=head;
        
        ListNode res=head;
        
        int count=1;
        
        while(head.next.next!=null){
            
            ListNode temp=head.next;
            
            if(count%2==0){
                
                //System.out.println(count + " " + head.val);
                head.next=head.next.next;
                
            }else{
                
                
                //System.out.println(count + " " + head.val);
                head.next=head.next.next;
            }
            
            count++;
            head=temp;
        }
        
        
        //System.out.println(head.next.val);
        
        if(count%2==0){
            ListNode temp2=head.next;
            head.next=null;
            head=temp2;
            head.next=t2;
        }else{
           head.next=t2; 
        }
        
        
        return res;
        
    }
}