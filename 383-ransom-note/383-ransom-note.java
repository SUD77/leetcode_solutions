class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> ransomMap=new HashMap<>();
        HashMap<Character,Integer> magazineMap=new HashMap<>();
        
        for(int i=0;i<ransomNote.length();i++){
            ransomMap.put(ransomNote.charAt(i),ransomMap.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        
        
        for(int i=0;i<magazine.length();i++){
            magazineMap.put(magazine.charAt(i),magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        
        for(int i=0;i<ransomNote.length();i++){
            
            if(!magazineMap.containsKey(ransomNote.charAt(i))) return false;
            if(ransomMap.get(ransomNote.charAt(i))>magazineMap.get(ransomNote.charAt(i))) return false; 
        
        }
        
        return true;
        
    }
}