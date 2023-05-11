class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        
        int len1=nums1.length;
        int len2=nums2.length;
        
        int[][] dp=new int[len1][len2];
        
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        
        return solUtil(nums1,nums2,0,0,dp);
    }
    
    public int solUtil(int[] nums1,int[] nums2, int indexNums1,int indexNums2,int[][] dp){
        
        if(indexNums1 == nums1.length || indexNums2==nums2.length) return 0;
        
        
        if(dp[indexNums1][indexNums2]!=-1) return dp[indexNums1][indexNums2];
            
        int makeLine=0;  // pick
        int notMakeLine=0; //notpick
        
        if(nums1[indexNums1]==nums2[indexNums2]){
            makeLine = 1 + solUtil(nums1,nums2,indexNums1+1,indexNums2+1,dp);
        }else{
            
            int moveNums1 = solUtil(nums1,nums2,indexNums1+1,indexNums2,dp);
            int moveNums2 = solUtil(nums1,nums2,indexNums1,indexNums2+1,dp);
            
            notMakeLine = Math.max(moveNums1,moveNums2);
        }
        
        return dp[indexNums1][indexNums2]=Math.max(makeLine,notMakeLine);
    }
}