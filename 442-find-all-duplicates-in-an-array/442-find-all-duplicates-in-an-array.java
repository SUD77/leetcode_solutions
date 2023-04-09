class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> ele:mp.entrySet()){
            int key=ele.getKey();
            int val=ele.getValue();
            
            if(val!=1){
                list.add(key);
            }
        }
        
        return list;
    
    }
}