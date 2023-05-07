/*
Appraoch : 

1. Keep two maps
2. One tracks, frequency of number
3. Second tracks, frequencies  (i.e frequency of frequencies)

*/

class FrequencyTracker {
    
    Map<Integer,Integer> map;
    Map<Integer,Integer> freqMap;
    
    
    public FrequencyTracker() {
        map=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public void add(int number) {
        
        /*
        - Here, if number already exists, so now it will get new frequency,
        - Thus, from freuqency map, we delete the count of older frequency. 
        
        */
        if(map.containsKey(number)){        
            int InitialFreq=map.get(number);
            freqMap.put(InitialFreq,freqMap.getOrDefault(InitialFreq,0)-1);
            if(freqMap.get(InitialFreq)==0) freqMap.remove(InitialFreq);
        }

        /*
        1. We increase the freq of number
        2. We get the new frequency
        3. Put/update the new frequency in freqency Map
        */
        map.put(number,map.getOrDefault(number,0)+1);
        int newFreq=map.get(number);
        freqMap.put(newFreq,freqMap.getOrDefault(newFreq,0)+1);
        
        
        
    }
    
    public void deleteOne(int number) {
        
        //if map doesnt contain, simply return
        if(!map.containsKey(number)) return;
        
        /*
        - As we are going to delete, so frequency will change. 
        - We will need to udpate the frequency map too
        */
        int InitialFreq=map.get(number);
        freqMap.put(InitialFreq,freqMap.getOrDefault(InitialFreq,0)-1);
        if(freqMap.get(InitialFreq)==0) freqMap.remove(InitialFreq);
        
        // Deleting the number, from map and decreasing freq by 1
        map.put(number,map.getOrDefault(number,0)-1);
        
        
        // Updating the frequecy of new frequecy
        int newFreq=map.get(number);
        freqMap.put(newFreq,freqMap.getOrDefault(newFreq,0)+1);
        
        
        if(map.get(number)==0) map.remove(number);
        
        
        //System.out.println(freqMap);
        
    }
    
    public boolean hasFrequency(int frequency) {
        
        if(freqMap.containsKey(frequency)) return true;
        return false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */