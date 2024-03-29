class Node{
    
    //size 2 because, of 0 or 1
    Node links[] = new Node[2];
    
    public Node(){
        
    }
    
    boolean containsKey(int index){
        return (links[index]!=null);
    }
    
    Node get(int index){
        return links[index];
    }
    
    void put(int index,Node node){
        links[index]=node;
    }
        
        
}

class Trie{
    
    private Node root;
    
    Trie(){
        root=new Node();
    }
    
    public void insert(int num){
        
        Node node = root;
        
        for(int i=31;i>=0;i--){
            
            int bit=(num>>i) & 1;
            
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            
            node=node.get(bit);
        }
    }
    
    public int getMax(int num){
        
        Node node=root;
        
        int maxNum=0;
        
        for(int i=31;i>=0;i--){
            
            int bit=(num>>i)&1;
            
            if(node.containsKey(1-bit)){
                maxNum=maxNum | (1<<i);
                node =node.get(1-bit);
            }else{
                node=node.get(bit);
            }
        }
        
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        
        Trie trie=new Trie();
        
        for(int i=0;i<nums.length;i++){
            
            trie.insert(nums[i]);
        }
        
        int maxi=0;
        
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,trie.getMax(nums[i]));
        }
        
        return maxi;
    }
}