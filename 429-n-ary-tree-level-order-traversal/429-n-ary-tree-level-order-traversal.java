/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        solUtil(root,result);
        
        return result;
    }
    
    public void solUtil(Node root,List<List<Integer>> result){
        
        if(root==null) return;
        
        
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> currSet=new ArrayList<>();
            
            int len=q.size();
            
            
            for(int i=0;i<len;i++){
                Node curr=q.poll();   //Assigning the head to curr and removing it. 
                currSet.add(curr.val);
                
                for(Node x:curr.children){
                    q.offer(x); // Inserting in queue
                }
    
            } 
            
            result.add(currSet);
            
        }
    }
    
    
}