/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        
        if(node==null) return null;
        
        Node vis[]=new Node[101];
        Arrays.fill(vis,null);
        
        Node result=new Node(node.val);
        
        dfs(node,result,vis);
        return result;
        
    }


    public void dfs(Node node,Node result,Node[] vis){
        
        vis[result.val]=result;
        
        for(Node n:node.neighbors){
            
            if(vis[n.val]==null){
                Node newNode=new Node(n.val);
                
                result.neighbors.add(newNode);
                dfs(n,newNode,vis);
            }else{
                
                result.neighbors.add(vis[n.val]);
            }
        }
    }
}
