class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        Set<List<Integer>> resultSet=new HashSet<>();
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> tempMap=new HashMap<>();

        if(nums==null||nums.length==0|| nums.length==1||nums.length==2)
        {
            return result;
        }
        
        for(int i=0;i<nums.length-1;i++){

            for(int j=i+1;j<nums.length;j++){
                List<Integer> tempList=new ArrayList<>();
                int diff= -nums[i] - nums[j];
                if(tempMap.containsKey(diff) && tempMap.get(diff)!=i && tempMap.get(diff)!=j)                 {
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(diff);
                    Collections.sort(tempList);
                    resultSet.add(tempList);
                }
                tempMap.put(nums[i],i);
                tempMap.put(nums[j],j);
            }
        }


        result.addAll(resultSet);
        
        return result;
    }
}