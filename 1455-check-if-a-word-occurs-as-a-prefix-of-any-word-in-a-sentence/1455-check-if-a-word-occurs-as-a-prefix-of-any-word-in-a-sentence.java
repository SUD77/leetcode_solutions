class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] strArray=sentence.split(" ");
        
        for(int i=0;i<strArray.length;i++){
            if(strArray[i].startsWith(searchWord)) return i+1;
        }
        
        return -1;
    }
}