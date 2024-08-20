class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> ans=new ArrayList<>();
        
        solUtil(0,s,wordDict,ans,new ArrayList<>());
        
        return ans;
        
    }
    
    public void solUtil(int start,String s,List<String> wordDict,List<String> ans, List<String> currentString){
        
        if(start==s.length()){
            ans.add(String.join(" ",currentString));
            return;
        }
        
        for(int end=start+1;end<=s.length();end++){
            
            if(wordDict.contains(s.substring(start,end))){
                currentString.add(s.substring(start,end));
                solUtil(end,s,wordDict,ans,currentString);
                currentString.remove(currentString.size()-1);
            }
        }
    }
}