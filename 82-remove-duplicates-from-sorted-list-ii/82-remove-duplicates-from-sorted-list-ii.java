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
    public ListNode deleteDuplicates(ListNode head) {
       
        Map<Integer,Integer> mp=new HashMap<>();
        Set<Integer> s = new TreeSet<>();
        
        ListNode res=new ListNode();
        ListNode resR=res;
        
        while(head!=null){
            mp.put(head.val,mp.getOrDefault(head.val,0)+1);
            head=head.next;
        }
        
        for(Map.Entry<Integer,Integer> ele:mp.entrySet()){
            
            if(ele.getValue()==1){
                s.add(ele.getKey());
            }
        }
        
        
        Iterator<Integer> it=s.iterator();

        while(it.hasNext()){
            ListNode temp=new ListNode(it.next());
            res.next=temp;
            res=temp;
        }
        
        return resR.next;

    }
}