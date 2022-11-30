class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
        
        for(int x:arr){
            temp.put(x,temp.getOrDefault(x,0)+1);
        }
        
        return temp.size() == new HashSet<>(temp.values()).size();
    }
}