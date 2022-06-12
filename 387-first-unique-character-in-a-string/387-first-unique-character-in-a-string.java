class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character,Integer> temp=new HashMap<>();
        
        for(char x:s.toCharArray()){
            temp.put(x,temp.getOrDefault(x,0)+1);
        }
        
        for(int i=0;i<s.length();i++){
            if(temp.get(s.charAt(i))==1){
                return i;
            }
        }
        
        
        return -1;
    }
}