class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        
        int size=q1.size();
        int i=0;
        
        while(i<size-1){
            q2.add(q1.poll());
            i++;
        }
        
        int res=q1.poll();
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        return res;
    }
    
    public int top() {
        
        int size=q1.size();
        if(q1.size()==0) return -1;
        
        int i=0;
        int res=0;
        
        while(i<size){
            res=q1.poll();
            q2.add(res);
            i++;
        }
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        return res;
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */