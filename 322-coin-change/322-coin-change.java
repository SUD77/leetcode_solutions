class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int n=coins.length;
        
        int[] prev=new int[amount+1];
        
        
        for(int i=0;i<=amount;i++){
            
            if(i%coins[0]==0) prev[i]=i/coins[0];
            else prev[i]=(int)(Math.pow(10,9));
        }
        
        for(int i=1;i<n;i++){
            
            int[] curr=new int[amount+1];
            
            for(int j=0;j<=amount;j++){
                
                int notPick=prev[j]; 
        
                int pick=(int)(Math.pow(10,9));

                if(j>=coins[i]){
                    pick=1+ curr[j-coins[i]]; 
                }

                curr[j]=Math.min(pick,notPick);
            }
            
            prev=curr;
        }
        
        if(prev[amount]!=(int)(Math.pow(10,9)))
            return prev[amount];
        
        return -1;
    }
    
    
}