class Solution {
    public List<String> letterCombinations(String digits) {
        
       String[] sMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();

        solUtil(digits,0,sMap,ans,new StringBuilder());
        
        return ans;
                
    }
    
    public static void solUtil(String digits,int index,String[] sMap,List<String> ans,StringBuilder sb){

        if(index==digits.length()){
            if(index==0) return;
            ans.add(sb.toString());
            return;
        }

        int number= digits.charAt(index)-'0';
        String letters=sMap[number];

        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            solUtil(digits,index+1,sMap,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}