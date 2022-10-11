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
        
        List<Integer> e=new ArrayList<>();
        List<Integer> o=new ArrayList<>();
        int countIndiceNo=1;
        
        ListNode result=new ListNode();
        ListNode resR=result;
        
        while(head!=null){
            
            if(countIndiceNo%2==0){
                e.add(head.val);
            }else{
                o.add(head.val);
            }
            head=head.next;
            countIndiceNo++;
        }
        
        for(Integer ele:o){
            ListNode temp1=new ListNode(ele);
            result.next=temp1;
            result=temp1;
        }
        
        for(Integer ele:e){
            ListNode temp2=new ListNode(ele);
            result.next=temp2;
            result=temp2;
        }
        
        return resR.next;
        
    }
}