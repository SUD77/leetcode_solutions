class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int maxArea=0;
        
        int n=matrix.length;
        int m=matrix[0].length;
        
        int[] height=new int[m];
        
        Arrays.fill(height,0);
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            
            int area=largestRectangleArea(height);
            maxArea=Math.max(area,maxArea);
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea(int[] histogram){
        
        Stack<Integer> st=new Stack<>();
        
        int maxA=0;
        int n=histogram.length;
        
        for(int i=0;i<=n;i++){
            
            while(!st.empty() && (i==n || histogram[st.peek()] >= histogram[i])){
                
                int height=histogram[st.peek()];
                
                st.pop();
                int width;
                
                if(st.empty())
                    width=i;
                else
                    width=i-st.peek()-1;
                maxA=Math.max(maxA,width*height);
            }
            
            st.push(i);
        }
        
        return maxA;
    }
}