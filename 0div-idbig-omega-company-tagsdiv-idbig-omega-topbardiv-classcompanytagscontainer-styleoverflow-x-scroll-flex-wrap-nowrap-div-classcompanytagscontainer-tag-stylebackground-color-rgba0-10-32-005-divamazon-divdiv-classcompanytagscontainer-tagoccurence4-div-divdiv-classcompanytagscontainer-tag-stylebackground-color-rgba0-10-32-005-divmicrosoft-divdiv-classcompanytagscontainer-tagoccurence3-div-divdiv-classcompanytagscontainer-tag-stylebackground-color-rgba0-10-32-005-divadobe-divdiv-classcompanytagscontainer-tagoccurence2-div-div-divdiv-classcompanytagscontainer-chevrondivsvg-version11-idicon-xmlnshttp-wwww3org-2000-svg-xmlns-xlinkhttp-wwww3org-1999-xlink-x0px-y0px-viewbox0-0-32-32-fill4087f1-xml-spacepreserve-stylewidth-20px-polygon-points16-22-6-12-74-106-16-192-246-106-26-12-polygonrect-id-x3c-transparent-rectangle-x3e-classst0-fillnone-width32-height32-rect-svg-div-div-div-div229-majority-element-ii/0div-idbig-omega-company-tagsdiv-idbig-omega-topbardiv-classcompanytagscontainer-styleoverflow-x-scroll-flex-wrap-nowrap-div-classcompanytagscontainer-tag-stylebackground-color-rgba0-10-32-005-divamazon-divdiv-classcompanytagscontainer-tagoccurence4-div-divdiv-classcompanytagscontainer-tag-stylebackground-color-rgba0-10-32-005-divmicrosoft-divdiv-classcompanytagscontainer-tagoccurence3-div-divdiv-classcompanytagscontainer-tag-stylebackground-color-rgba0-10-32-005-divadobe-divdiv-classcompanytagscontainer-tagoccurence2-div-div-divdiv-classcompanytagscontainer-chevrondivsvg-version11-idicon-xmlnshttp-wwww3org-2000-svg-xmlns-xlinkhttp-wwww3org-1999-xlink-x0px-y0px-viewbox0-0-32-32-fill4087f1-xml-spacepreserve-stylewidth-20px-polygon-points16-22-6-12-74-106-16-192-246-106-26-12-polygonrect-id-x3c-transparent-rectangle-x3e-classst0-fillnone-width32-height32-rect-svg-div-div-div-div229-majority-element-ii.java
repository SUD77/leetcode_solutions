class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n=nums.length;
        
        List<Integer> ans=new ArrayList<>();
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        // System.out.println(map);
        
        for(int i=0;i<n;i++){
            if(map.get(nums[i])>(int) (Math.floor(n/3))){
                if(!ans.contains(nums[i]))ans.add(nums[i]);
            }
        }
        
        return ans;
    }
}