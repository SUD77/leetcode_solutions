class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        StringBuilder sb=new StringBuilder();

        for(String x:words){
            sb.append(x);
            if(sb.toString().equals(s)) return true;
        }
        
        // if(sb.toString().startsWith(s)) return true;
        
        return false;
    }
}