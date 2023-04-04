class Solution {
    public int partitionString(String s) {
        
        int n = s.length();
        int result = 0 ;
        Set<Character> set = new TreeSet<>();

        char[] tempCh=s.toCharArray();

        for(char ch:tempCh){
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
                result++;
                set.clear();
                set.add(ch);
            }
        }
        
        
        return ++result;
    }
}