class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> ans=new ArrayList<>();
        
        backtrack(s,wordDict,ans,new ArrayList<String>(),0);
        
        return ans;
    }
    
    public void backtrack(String s, List<String> wordDict,List<String> ans,List<String> currentString,int start){
        
        
        if(start==s.length()){
            ans.add(String.join(" ",currentString));
            return;
        }
        
        for(int end=start+1;end<=s.length();end++){
            
            if(wordDict.contains(s.substring(start,end))){
                currentString.add(s.substring(start,end));
                backtrack(s,wordDict,ans,currentString,end);
                currentString.remove(currentString.size()-1);
            }
        }
    }
}