class FrequencyTracker {
    
    Map<Integer,Integer> map;
    Map<Integer,Integer> freqMap;
    
    
    public FrequencyTracker() {
        map=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public void add(int number) {
        
        if(map.containsKey(number)){        
            int InitialFreq=map.get(number);
            freqMap.put(InitialFreq,freqMap.getOrDefault(InitialFreq,0)-1);
            if(freqMap.get(InitialFreq)==0) freqMap.remove(InitialFreq);
        }

        map.put(number,map.getOrDefault(number,0)+1);
        int newFreq=map.get(number);
        freqMap.put(newFreq,freqMap.getOrDefault(newFreq,0)+1);
        
        //System.out.println(freqMap);
        
    }
    
    public void deleteOne(int number) {
        
        
        if(!map.containsKey(number)) return;
        
        int InitialFreq=map.get(number);
        freqMap.put(InitialFreq,freqMap.getOrDefault(InitialFreq,0)-1);
        if(freqMap.get(InitialFreq)==0) freqMap.remove(InitialFreq);
        
        map.put(number,map.getOrDefault(number,0)-1);
        
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