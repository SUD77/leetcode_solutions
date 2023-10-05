class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n=nums.length;
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        Map<Integer,Integer> mp=new HashMap<>();
        
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
            
            if(mp.get(x)>Math.floor(n/3)){
                if(!arr.contains(x)) arr.add(x);
            }
        }
        
        
        return arr;
        
    }
}