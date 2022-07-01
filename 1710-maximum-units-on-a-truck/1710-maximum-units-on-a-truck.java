class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
      
        Arrays.sort(boxTypes, (a,b) -> (b[1]-a[1]));
        
        int totalUnits=0;
        
        // [[1,3],[2,2],[3,1]]
        
        for(int i=0;i<boxTypes.length;i++){
            
            if(boxTypes[i][0]<=truckSize){
                
                totalUnits +=boxTypes[i][0] * boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }else if(boxTypes[i][0]>truckSize){
                
                totalUnits+=truckSize*boxTypes[i][1];
                break;
                
                
            }
            
        }
        
        return totalUnits;
    }
}