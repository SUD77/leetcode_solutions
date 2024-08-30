class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st=new Stack<>();
        int maxA=0;
        
        int n=heights.length;
        
        for(int i=0;i<=n;i++){
            
            /*
            1. Here, i==n is for the last case, i.e when we cover whole 
            histogram. 
            2. heights[st.peek()] >= heights[i] means, we have found, nse (next smaller element) at i.
            and will do computation of area of few of the previous elements
            
            */
            
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])){
                
                int height=heights[st.peek()];
                st.pop();
                
                int width;
                
                // if condition is just for initial case, till we find the first nse
                if(st.isEmpty()){
                    width=i;
                } else {
                    width = i-st.peek()-1;
                }
                
                maxA=Math.max(maxA,width*height);
            }
            st.push(i);
        }
        
        return maxA;
    }
}