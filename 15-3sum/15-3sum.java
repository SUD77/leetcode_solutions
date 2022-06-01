class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        /*Sorting before as to remove the conflicts, when adding duplicates 
        in hashmap, bcoz KEY will be unique but value will change (and value is position             no)*/
        Arrays.sort(nums);
        
        //Set is to avoid the duplicates. 
        Set<List<Integer>> resultSet=new HashSet<>();
        
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> tempMap=new HashMap<>();

        //Initial check for boundary cases.
        if(nums==null||nums.length==0|| nums.length==1||nums.length==2)
        {
            return result;
        }
        
        /*Logic: Keeping one element fixed (here i), and then applying the concenpt of twoSum here. */
        for(int i=0;i<nums.length-1;i++){

            for(int j=i+1;j<nums.length;j++){
                
                List<Integer> tempList=new ArrayList<>();
                
                int diff= -nums[i] - nums[j];
                
                if(tempMap.containsKey(diff) && tempMap.get(diff)!=i && tempMap.get(diff)!=j)                 {
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(diff);
                    /*Sorting here to avoid addition of duplicates in set*/
                    Collections.sort(tempList); 
                    
                    resultSet.add(tempList);
                }
                tempMap.put(nums[i],i);
                tempMap.put(nums[j],j);
            }
        }

        //Adding all the list in set in final result list. 
        result.addAll(resultSet);
        
        return result;
    }
}