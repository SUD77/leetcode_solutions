/*So we count the frequnce freq for each level.

If freq = 1, not possible, return -1
If freq = 2, needs one 2-tasks
If freq = 3, needs one 3-tasks
If freq = 3k, freq = 3 * k, needs k batchs.
If freq = 3k + 1, freq = 3 * (k - 1) + 2 + 2, needs k + 1 batchs.
If freq = 3k + 2, freq = 3 * k + 2, needs k + 1 batchs.

To summarize, needs (freq + 2) / 3 batch,
return the sum of (freq + 2) / 3 if possible.
*/



class Solution {
    public int minimumRounds(int[] tasks) {
        
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        
        int result=0;
        
        for(int x:tasks){
            freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        }
        
        for(int count:freqMap.values()){
            
            if(count==1) return -1;
            
            result+=(count+2)/3;
        }
        
        return result;
        
        
    }
}