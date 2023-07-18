class LRUCache {

    int capacity;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> mp=new HashMap<>();
    
    public LRUCache(int capacity) {
    
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
       if(mp.containsKey(key)){
           Node node=mp.get(key);
           remove(node);
           insert(node);
           
           return node.value;
       }
       return -1; 
        
    }
    
    public void put(int key, int value) {
        
        //check in map
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        
        //check in size
        if(mp.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
        
    }
    
    public void insert(Node node){
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        
        node.next=headNext;
        headNext.prev=node;
//         node.next=head.next;
//         node.prev=head;
        
        mp.put(node.key,node);
    }
    
    
    public void remove(Node node){
        mp.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        
    }
    
    
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */