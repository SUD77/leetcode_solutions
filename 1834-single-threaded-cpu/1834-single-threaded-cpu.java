class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n=tasks.length;
        
        Task[] temp=new Task[n];
        
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++){
            temp[i]=new Task(i, tasks[i][0], tasks[i][1]);
        }
        
        
        Arrays.sort(temp, (a,b)->{
           return Integer.compare(a.enqTime,b.enqTime); 
        });
        
        PriorityQueue<Task> pq=new PriorityQueue<>((a,b)->{
            
            if(a.processTime == b.processTime){
                return Integer.compare(a.index,b.index);
            }
            
            return Integer.compare(a.processTime,b.processTime);
        });
        
        int ansIndex=0;
        int taskIndex=0;
        int curTime=0;
        
        while(ansIndex < n){
            
            while(taskIndex < n && temp[taskIndex].enqTime <= curTime){
                pq.offer(temp[taskIndex++]);
            }
            
            if(pq.isEmpty()){
                curTime=temp[taskIndex].enqTime;
            }else{
                curTime += pq.peek().processTime;
                ans[ansIndex++]=pq.poll().index;
            }
        }
        
        return ans;
    }
    
    class Task{
        
        int index;
        int enqTime;
        int processTime;
        
        Task(int index,int enqTime,int processTime){
            this.index=index;
            this.enqTime=enqTime;
            this.processTime=processTime;
        }
    }
}