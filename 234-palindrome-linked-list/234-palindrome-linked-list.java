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
    public boolean isPalindrome(ListNode head) {
    

        
        ListNode tempx=copyList(head);
         
        ListNode ReverseHead=reverseList(tempx);
        
        while(head!=null && ReverseHead!=null){
            
            
            if(ReverseHead.val!= head.val){
                return false;
            }
            head=head.next;
            ReverseHead=ReverseHead.next;
        }
        
        return true;
    }
    
    
    public ListNode reverseList(ListNode head) {
        
      ListNode Rll=null;
        
        while(head!=null){
            ListNode temp=head;
            temp=temp.next;
            head.next=Rll;
            Rll=head;
            head=temp;
        }
        
        return Rll;
    }
    
    public ListNode copyList(ListNode head)
    {
        ListNode current = head;    // used to iterate over the original list
        ListNode newList = null;    // head of the new list
        ListNode tail = null;       // point to the last node in a new list
 
        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new ListNode(current.val, null);
                tail = newList;
            }
            else {
                tail.next = new ListNode();
                tail = tail.next;
                tail.val = current.val;
                tail.next = null;
            }
            current = current.next;
        }
 
        return newList;
    }
    
    
}