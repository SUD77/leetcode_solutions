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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
     
        /*Approach
        1. Keep count pointer, iterate till its not equal to left. Remove the connection
        2. Iterate further till, its not equal to right. Remvoe connection.
        3. Reverse the req linked list.
        4. make connections back.
        
        */
        
        int count=1;
        
        ListNode firstLinkedEnd=new ListNode(1);
        ListNode midLinkedStart=head;
        firstLinkedEnd.next=midLinkedStart;
        
        
        while(count!=left){
            
            firstLinkedEnd=firstLinkedEnd.next;
            midLinkedStart=midLinkedStart.next;
            count++;
        }
        
        
        
        ListNode midLinkedEnd=midLinkedStart;
        
        while(count!=right){
            midLinkedEnd=midLinkedEnd.next;
            count++;
        }
        
        ListNode lastListStart=midLinkedEnd.next;
        midLinkedEnd.next=null;
       
        
        //reversing mid list
        ListNode temp=reverseList(midLinkedStart);
       
        
        
        //connecting first list to mid list
        firstLinkedEnd.next=temp;
        
        //to conenct last list
        ListNode temp2=head;
        
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        
        temp2.next=lastListStart;
        
        if(left==1){
            head=temp;
        }
        
        
        return head;
        
        
        
        
    }
    
    public ListNode reverseList(ListNode head){
        
        
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