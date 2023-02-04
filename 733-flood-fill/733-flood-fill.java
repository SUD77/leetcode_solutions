class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        boolean[][] vis=new boolean[image.length][image[0].length];
        
        int start=image[sr][sc];
        dfs(image,sr,sc,color,start,vis);
        return image;
    }
    
    public void dfs(int[][] image, int x, int y, int color,int start,boolean[][] vis){
        
        if(x<0 || y<0 || x>=image.length || y>=image[0].length) return;
        
        if(vis[x][y]) return;
        
        if(image[x][y]!=start) return;
        
        vis[x][y]=true;
        
        if(image[x][y]==start) image[x][y]=color;
        
        dfs(image,x+1,y,color,start,vis);
        dfs(image,x-1,y,color,start,vis);
        dfs(image,x,y+1,color,start,vis);
        dfs(image,x,y-1,color,start,vis);
        
    }
}