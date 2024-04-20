class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++){
            
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<i; j++){                
                if(j == 0 || j == i-1){
                    temp.add(1);
                }
                else{
                    int ele = prev.get(j-1) + prev.get(j);
                    temp.add(ele);
                }
            }
            res.add(temp);
            prev = temp;
        }
        
        return res;
    }
}