class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res=new ArrayList<>();
        
        solUtil(0,s,res,new ArrayList<>());
        
        return res;
    }
    
    
    public void solUtil(int currIndex,String s,List<List<String>> res,List<String> tempList){
        
        if(currIndex>=s.length()){
            
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        
        for(int i=currIndex;i<s.length();i++){
            
            if(isPalindrome(s.substring(currIndex,i+1))){
                tempList.add(s.substring(currIndex,i+1));
                solUtil(i+1,s,res,tempList);
                tempList.remove(tempList.size()-1);
            }
           
            
             
        }
        
        
        
    }
    
    public boolean isPalindrome(String s){
        
        int n=s.length();
        int j=n-1;
        
        int i=0;
        
        while(i<j){
        
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        
            i++;
            j--;
       
        }
    
     return true;
    
    }
}