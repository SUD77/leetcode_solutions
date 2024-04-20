//Shivangi Code optimization
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++){
            
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<i; j++){                
                if(j == 0 || j == i-1){
                    temp.add(1);
                }
                else{
                    //int ele = prev.get(j-1) + prev.get(j);
                    int ele = res.get(i-2).get(j-1) + res.get(i-2).get(j); //i starts from 1 and not 0, thats why we are doing res(i-2) to go to prev array in res
                    temp.add(ele);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}
