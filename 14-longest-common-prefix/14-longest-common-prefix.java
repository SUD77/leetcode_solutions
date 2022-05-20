class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        //If String array is empty, so return empty String
        if(strs==null || strs.length ==0){
            return "";
        }
        
        //To store the final result
        StringBuilder sb=new StringBuilder();
        
        
        /* This sorting is required as, if ALL words in string have common letters, then we can compare directly compare first and last to check how many are common.
        */
        Arrays.sort(strs);
        
        int c=0;
        
        String first=strs[0];
        String last=strs[strs.length-1];
        
        while(c<first.length()){
            
            if(first.charAt(c)==last.charAt(c)){
                sb.append(first.charAt(c));
                c++;
            }else{
                return sb.toString();
            }
        }
        
        return sb.toString();
    }
}