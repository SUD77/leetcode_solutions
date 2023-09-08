class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> finalList=new ArrayList<>();
        
        generatePascalTriangle(numRows,0,finalList);
        
        return finalList;
    }
    
    public void generatePascalTriangle(int numRows,int currentRowNo,List<List<Integer>> finalList){
        
        if(currentRowNo>=numRows) return;
        
        List<Integer> tempListToStoreRow=new ArrayList<>();
        
        for(int i=0;i<=currentRowNo;i++){
            
            if(i==0 || i==currentRowNo) tempListToStoreRow.add(1);
            else{
                tempListToStoreRow.add(finalList.get(currentRowNo-1).get(i-1) + finalList.get(currentRowNo-1).get(i) );
            }
        }
        
        finalList.add(tempListToStoreRow);
        
        generatePascalTriangle(numRows,currentRowNo+1,finalList);
        
        return;
        
    }
}