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


/**
Note :
1. When list len is odd, then while loop is going to break at the point when head is at even count (position) node;
2. When list len is even, then while loop is going to break at the point when head is at odd count (position) node;


*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode t2=head.next;
        
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
        
		// So, if count is even position, then the length of list is odd
		// if count is odd position, then the length of list is even, (Else condition here)
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