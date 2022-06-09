class Solution {
    public List<List<Integer>> generate(int numRows) {
      
        
        //iterative
        
        List<List<Integer>> result=new ArrayList<List<Integer>>();     
        
        for(int i=0;i<numRows;i++){
            
             ArrayList<Integer> row=new ArrayList<Integer>();
            
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    int x=result.get(i-1).get(j-1);
                    int y=result.get(i-1).get(j);
                    row.add(x+y);
                }
            }
            
            result.add(row);
        }
        
        return result;
    }
}