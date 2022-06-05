class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        /*Logic : We will keep hashmap, to tack the elements present in 
        nums and then , we will iterate through 1 to n, to check which element is not in hashmap and then add that to result list.     
        */
        HashMap<Integer,Boolean> temp=new HashMap<>();
        List<Integer> result=new ArrayList<>();

        int size= nums.length;

        for(int x:nums){
            temp.put(x,true);
        }

        for(int i=1;i<=size;i++){
            if(!temp.containsKey(i)){
                result.add(i);
            }

        }
        
        return result;
    }
}