class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Map<String, Integer> mp=new HashMap<>();
        
        
        //Putting values in map
        for(int i=0;i<arr.length;i++){
            
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i]) + 1);
            }else{
                mp.put(arr[i],1);
            }
        }
        
        //counter to monitor the value getting equal to key
        int count=0;
        
        
        //Iterating through array and checking in map, the value of count of that string
        for(int i=0;i<arr.length;i++){
            
            if(mp.get(arr[i]) == 1){
                count++;
            }
            
            if(count==k){
                return arr[i];
            }
        }
        
        
        
//         for(Map.Entry<String, Integer> entry:mp.entrySet()){
//             System.out.println(entry.getKey() + " " + entry.getValue());
//         }
        
        return "";
        
    }
}