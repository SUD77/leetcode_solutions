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
    public ListNode swapNodes(ListNode head, int k) {
        
         ListNode cur  = head;
        
       
        int n=0;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        
        int cnt=0;
        cur = head;        
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
      
        while(cur != null) {
            cnt++;
            if(cnt == k) {
                temp1 = cur;
            }
            if(cnt == n-k+1) {
                temp2 = cur;
            }
            cur = cur.next;
        }
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
        
        return head;
    }
}