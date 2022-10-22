class Solution {
    public List<List<String>> partition(String s) {
       
        List<List<String>> res=new ArrayList<>();
        
        solUtil(s,res,new ArrayList<>(),0);
        
        return res;
    }
    
    public void solUtil(String s,List<List<String>> res,List<String> tempArr,int index){
        
        if(index==s.length()){
            
            res.add(new ArrayList(tempArr));
            return;
        }
        
        
        for(int i=index;i<s.length();i++){
            
            if(isPalindrome(s,index,i)==true){
                tempArr.add(s.substring(index,i+1));
                solUtil(s,res,tempArr,i+1);
                tempArr.remove(tempArr.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int index,int k){
        
        int i=index;
        int j=k;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}


