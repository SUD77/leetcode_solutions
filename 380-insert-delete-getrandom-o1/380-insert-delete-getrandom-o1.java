class RandomizedSet {

    List<Integer> storage;
    
    public RandomizedSet() {
        storage=new ArrayList<>();    
    }
    
    public boolean insert(int val) {
        
        if(!storage.contains(val)){
            
            storage.add(val);
            return true;
        }
        
        return false;
    }
    
    public boolean remove(int val) {
        
        if(storage.contains(val)){
            storage.remove((Integer)val);
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        
        int randomN=new Random().nextInt(storage.size());
        
        return storage.get(randomN);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */