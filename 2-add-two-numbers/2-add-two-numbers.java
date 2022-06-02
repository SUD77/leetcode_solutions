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
        
        ListNode l3=new ListNode();
        ListNode temp=new ListNode();
        
        l3.next=temp;
        
        int carry=0;
        
        while(l1!=null && l2!=null){
            
            int x=l1.val+l2.val+carry;
            carry=0;
            
            if(x>9){
                carry=x/10;
                x=x%10;
            }
            
            
            ListNode temp2=new ListNode();
            temp2.val=x;
            
            temp.next=temp2;
            temp=temp2;
            
            l1=l1.next;
            l2=l2.next;
            
        }
        
        while(l1!=null){
            int x=l1.val+carry;
            carry=0;
            
            if(x>9){
                carry=x/10;
                x=x%10;
            }
            
            
            ListNode temp2=new ListNode();
            temp2.val=x;
            
            temp.next=temp2;
            temp=temp2;
            
            l1=l1.next;
        }
        
         while(l2!=null){
            int x=l2.val+carry;
            carry=0;
            
            if(x>9){
                carry=x/10;
                x=x%10;
            }
            
            
            ListNode temp2=new ListNode();
            temp2.val=x; 
             
             
            temp.next=temp2;
            temp=temp2;
            
            l2=l2.next;
        }
        
        if(carry>0){
           ListNode temp2=new ListNode();
            temp2.val=carry; 
             
             
            temp.next=temp2;
            temp=temp2; 
        }
        
        return l3.next.next;
    }
}