class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        q1.add(x);
    }
    
    public int pop() {
        
        int lastEle=-1;
        
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                lastEle=q1.poll();
                if(!q1.isEmpty())
                    q2.add(lastEle);
            }
        }else {
            while(!q2.isEmpty()){
                lastEle=q2.poll();
                if(!q2.isEmpty())
                    q1.add(lastEle);
            }
        }
        
        return lastEle;
    }
    
    public int top() {
        int lastEle=-1;
        
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                lastEle=q1.poll();
                q2.add(lastEle);
            }
        }else {
            while(!q2.isEmpty()){
                lastEle=q2.poll();
                q1.add(lastEle);
            }
        }
        
        return lastEle;
    }
    
    public boolean empty() {
        
        if(!q1.isEmpty() || !q2.isEmpty()) return false;
        return true;
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