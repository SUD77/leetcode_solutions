class Solution {
    public int numDupDigitsAtMostN(int n) {
     
        List<Integer> list=new ArrayList<>();
        
        int count=0;
        
        int temp=n+1;
        
        while(temp!=0){
            list.add(0,temp%10);
            temp=temp/10;
        }
        
        for(int i=0;i<list.size()-1;i++){
            count+=9*permutation(9,i);
        }
        
        
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<list.size();i++){
            
            for(int j= i==0?1:0; j<list.get(i);j++){
                
                if(set.contains(j)) continue;
                else count+=permutation(10-(i+1),list.size()-1-i);
            }
            
            if(set.contains(list.get(i))) break;
            set.add(list.get(i));
        }
        
        return n-count;
    }
    
    private int permutation(int n,int r){
        
        int nonRepeatingNo=1;
        
        for(int i=0;i<r;i++){
            
            nonRepeatingNo*=n;
            n--;
            
        }
        return nonRepeatingNo;
    }
}