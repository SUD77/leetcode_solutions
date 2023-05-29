class ParkingSystem {

    Map<Integer,Integer> map;
    public ParkingSystem(int big, int medium, int small) {
        map=new HashMap<>();
        map.put(1,big);
        map.put(2,medium);
        map.put(3,small);
    }
    
    public boolean addCar(int carType) {
        
        if(map.get(carType)==0) return false;
        
        int currCapacity=map.get(carType);
        
        map.put(carType,currCapacity-1);
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */