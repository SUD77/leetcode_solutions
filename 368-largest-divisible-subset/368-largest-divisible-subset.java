class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n=nums.length;
        int maxAns=1;
        int lastIndex=0;
        
        Arrays.sort(nums);
        
        //We will fill dp with 1, as indiviudal ele are LIS of size 1
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        /*
        Hash will store INDEX of the last smaller ele than the curr ele. 
        */
        int[] hash=new int[n];
        
        for(int index=0;index<n;index++){
            
            //assigns the index of ele itself. 
            hash[index]=index;
            
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                
               if(nums[index]%nums[prevIndex]==0 
                 && 1+dp[prevIndex] > dp[index]){
                   
                   dp[index]=1+dp[prevIndex];
                   hash[index]=prevIndex;
               }
            }
           
            
            if(dp[index] > maxAns){
                maxAns=dp[index];
                lastIndex=index;
            }
            
        }
        
        List<Integer> temp=new ArrayList<>();
        temp.add(nums[lastIndex]);
        
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            temp.add(nums[lastIndex]);
        }
           
        
        Collections.reverse(temp);
        
        // for(int x:temp){
        //     System.out.println(x + " ");
        // }
        
        return temp; 
        
    }
}