/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
       Map<Node,Node> mp=new HashMap<>();
        
        Node dummy=head;
        
        while(dummy!=null){
            
            Node temp=new Node(dummy.val);
            mp.put(dummy,temp);
            dummy=dummy.next;
        }
        
        dummy=head;
        Node res=mp.get(dummy);
        
        while(dummy!=null){
            
            Node deepCopy=mp.get(dummy);
            deepCopy.next=mp.get(dummy.next);
            deepCopy.random=mp.get(dummy.random);
            
            dummy=dummy.next;
        }
        
        return res;
    }
}