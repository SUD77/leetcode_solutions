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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res=new ListNode();
        ListNode refR=res;
        
        ListNode t1=reverse(l1);
        ListNode t2=reverse(l2);
        int carry=0;
        
        while(t1!=null && t2!=null){
            
            int tempVal=t1.val+t2.val+carry;
            carry=0;
            
            if(tempVal>9){
                carry=tempVal/10;
                tempVal=tempVal%10;
            }
            
            ListNode temp=new ListNode(tempVal);
            res.next=temp;
            res=temp;
            
            t1=t1.next;
            t2=t2.next;
        }
        
        while(t1!=null){
            int tempVal=t1.val+carry;
            carry=0;
            
            if(tempVal>9){
                carry=tempVal/10;
                tempVal=tempVal%10;
            }
            
            ListNode temp=new ListNode(tempVal);
            res.next=temp;
            res=temp;
            
            t1=t1.next;
        }
        
        while(t2!=null){
            int tempVal=t2.val+carry;
            carry=0;
            
            if(tempVal>9){
                carry=tempVal/10;
                tempVal=tempVal%10;
            }
            
            ListNode temp=new ListNode(tempVal);
            res.next=temp;
            res=temp;
            
            t2=t2.next;
        }
        
        if(carry>0){
            ListNode temp=new ListNode(carry);
            res.next=temp;
            res=temp;
        }
        
        refR=reverse(refR.next);
        return refR;
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode Rll=null;
        
        while(head!=null){
            ListNode temp=head.next;
            head.next=Rll;
            Rll=head;
            head=temp;
        }
        
        return Rll;
    }
}