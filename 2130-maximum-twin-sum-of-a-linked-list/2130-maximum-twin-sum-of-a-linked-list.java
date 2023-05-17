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
    public int pairSum(ListNode head) {
        
        int size=0;
        
        ListNode temp=head;
        
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        
        int[] arr=new int[size];
        int j=0;
        
        while(head!=null){
            arr[j]=head.val;
            j++;
            head=head.next;
        }
        
        int i=0;
        int k=size-1;
        int max=0;
        
        // for(int x:arr){
        //     System.out.println(x);
        // }
        
        while(i<k){
            
            int var=arr[i] + arr[k];
            if(var>=max){
                max=var;
            }
            i++;
            k--;
        }
        
        //System.out.println(size);
        
        return max;
        
    }
}