class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> eleCount=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        
        for(int x:nums){
            eleCount.put(x,eleCount.getOrDefault(x,0)+1);
        }
        
        System.out.println(eleCount);
        
        for(int x:nums){
            
            if(!result.contains(x) && eleCount.get(x)> (int) Math.floor(nums.length/3)) {
                result.add(x);
            }
        }
         
        return result;
    }
}