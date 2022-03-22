class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        
        Map<Integer,Integer> temp1=new HashMap<>();
        Map<Integer,Integer> temp2=new HashMap<>();
        
        for(int x:target){
            temp1.put(x,temp1.getOrDefault(x,0)+1);
        }
        
        for(int x:arr){
            temp2.put(x,temp2.getOrDefault(x,0)+1);
        }
        
        for(int x:arr){
            if(temp1.get(x)!=temp2.get(x)) return false;
        }
        
        return true;
        
        
    }
}