class Solution {
    public String getPermutation(int n, int k) {
        
        int fact=1;
        String ans="";
        List<Integer> tempArray=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            tempArray.add(i);
            fact*=i;
        }
        
        
        k=k-1;
        fact=fact/n;
        
       
        while(true){
            
            int curEle = tempArray.get(k/fact);
            ans=ans+ (tempArray.get(k/fact));
             
            tempArray.remove(k/fact);
            
            if(tempArray.size()==0) break;
            
            k=k%fact;

            fact=fact/tempArray.size();
            
            
        }
        
        return ans;
    }
}