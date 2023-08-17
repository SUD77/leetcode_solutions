class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n=mat.length;
        int m=mat[0].length;
        
        boolean[][] vis=new boolean[n][m];
        int[][] dis=new int[n][m];
        
        Queue<Node> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=true;
                }
               
            }
        }
        
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        
        while(!q.isEmpty()){
            
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            
            q.remove();
            
            dis[row][col]=steps;
            
            for(int i=0;i<4;i++) {
                
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !vis[nRow][nCol]){
                    vis[nRow][nCol]=true;
                    q.add(new Node(nRow,nCol,steps+1));
                }
            }
        }
        
        return dis;
    }
    
    class Node{
        int first;
        int second;
        int third;
        
        Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
}