class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid==null || grid.length==0) return 0;
        
        int rows=grid.length;
        int cols=grid[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        
        int countFresh=0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                //if it is rotten, put in queue.
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
                
                //if it is fresh i.e equal to 1, then count it.
                if(grid[i][j]!=0) countFresh++;
            }
            
        }
        
        if(countFresh==0) return 0;
        
        int countMin=0;
        int count=0;
        
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        while(!queue.isEmpty()){
            
            int size=queue.size();
            count+=size;
            
            for(int i=0;i<size;i++){
                
                int[] point=queue.poll();
                
                for(int j=0;j<4;j++){
                    
                    int x=point[0] + dx[j];
                    int y=point[1] + dy[j];
                    
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2) continue;
                    
                    grid[x][y]=2;
                    
                    queue.offer(new int[]{x,y});
                }
            }
            
            if(queue.size()!=0){
                countMin++;
            }
        }
        
        return countFresh==count? countMin:-1;
    }
}