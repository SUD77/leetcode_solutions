class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> tMap=new HashMap<>();
        
        for(Integer i=0;i<s.length();i++){
           
            if(sMap.put(s.charAt(i),i) != tMap.put(t.charAt(i),i))
                return false;
        }
        
        
        
        return true;
    }
}