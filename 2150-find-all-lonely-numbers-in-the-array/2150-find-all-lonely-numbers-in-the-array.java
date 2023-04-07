//TC - O(n)
//SC - O(n)
class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        
        for(int x:nums){
            
            if(mp.get(x)==1 && !mp.containsKey(x-1) && !mp.containsKey(x+1)){
                ans.add(x);
            }
        }
        
        return ans;
    }
}