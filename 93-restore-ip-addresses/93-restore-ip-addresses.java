class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res=new ArrayList<>();
        solUtil(s,0,0,"",res);
        return res;
    }
    
    public void solUtil(String s,int i,int partition,String ans,List<String> res){
        
        //bsse case
        
        if(i==s.length() || partition==4){
            
            if(s.length()==i && partition==4){
                
                res.add(ans.substring(0,ans.length()-1));
            }
            
            return;
        }
        
        solUtil(s,i+1,partition+1,ans+s.charAt(i)+".",res);
        
        if(i+2<=s.length() && isValid(s.substring(i,i+2)))
            solUtil(s,i+2,partition+1,ans+s.substring(i,i+2)+".",res);
        if(i+3<=s.length() && isValid(s.substring(i,i+3)))
            solUtil(s,i+3,partition+1,ans+s.substring(i,i+3)+".",res);
        
    }
    
    public boolean isValid(String s){
        
        if(s.charAt(0)=='0'){
            return false;
        }
        
        int val=Integer.parseInt(s);
        
        return val<=255;
    }
}