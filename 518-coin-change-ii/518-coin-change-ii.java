//Space optimization
// TC - O(n*amount)
// Sc - O(amount)

class Solution {
    public int change(int amount, int[] coins) {
        
        int n=coins.length;
        
        int[] prev=new int[amount+1];
        
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) prev[i]=1;
            else prev[i]=0;
        }
        
        for(int i=1;i<n;i++){
            
            int[] curr=new int[amount+1];
            
            for(int j=0;j<=amount;j++){
                
                int notPick=prev[j]; 
        
                int pick=0;

                if(j >=coins[i]){
                    pick=curr[j-coins[i]]; 
                }

                curr[j]=pick+notPick;
                
            }
            prev=curr;
        }
        
        return prev[amount];
    }
    
}