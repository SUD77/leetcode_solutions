class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        //to track string and its frequency. 
        Map<String,Integer> temp=new HashMap<>();
        
        //Final answer to be returned.
        List<String> result=new ArrayList<>();
        
        //Adding String and its frequency in map
        for(String x:words){
            temp.put(x,temp.getOrDefault(x,0)+1);
        }
        
        
        //To put string at their respective frequency in the bucket
        List<String>[] bucket=new List[words.length + 1];
        
        for(String key: temp.keySet()){
            int frequency=temp.get(key);
            
            if(bucket[frequency]==null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        
        
        //To check, if we got k most frequent no.
        int count=0;
        
        
        for(int pos=bucket.length-1; pos>=0;pos--){
            
            
            if(bucket[pos] != null){
                
                //To get lexicographical order of same frequency Strings
                Collections.sort(bucket[pos]);
                
                for(String x:bucket[pos]) {
                    result.add(x);
                    count++;
                    
                    if(count == k){
                        return result;
                    }
                }    
                
            }
            
            
        }
        
        
        return result;
    }
}