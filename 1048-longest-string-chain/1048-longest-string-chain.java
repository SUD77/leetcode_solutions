//Strivers solution 

class Solution {
    public int longestStrChain(String[] words) {
        
        
        Arrays.sort(words, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.length()-o2.length();
             }
         });
        
        
        int n=words.length;
        int maxAns=1;
        
        
        //We will fill dp with 1, as indiviudal ele are LIS of size 1
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        for(int index=0;index<n;index++){
            
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                
               if(checkPossible(words[index],words[prevIndex])
                 && 1+dp[prevIndex] > dp[index]){
                   
                   dp[index]=1+dp[prevIndex];
                   
               }
            }
           
            
            if(dp[index] > maxAns){
                maxAns=dp[index];
                
            }
            
        }
        
        
        return maxAns; 
    }
    
    public boolean checkPossible(String s1,String s2){
        
        if(s1.length()!=s2.length()+1) return false;
        
        int first=0;
        int second=0;
        
        while(first<s1.length()){
            
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        
        if(first==s1.length() && second==s2.length()) return true;
        else return false;
    }
}