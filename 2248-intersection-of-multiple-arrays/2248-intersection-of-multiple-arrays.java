class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> list=new ArrayList<>();
         
        for(int[] x:nums){
            for(int y:x){
             mp.put(y,mp.getOrDefault(y,0)+1);
            }
        }

        for(Map.Entry<Integer,Integer> ele:mp.entrySet()){
            if(ele.getValue()== nums.length) list.add(ele.getKey());
        }
        
        Collections.sort(list);
        
        return list;
    }
}