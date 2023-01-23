class Solution {
    public int findJudge(int n, int[][] trust) {
        
        
        /*** Using ArayList (failed)
        List<Integer> result=new ArrayList<Integer>();
        
        for(int[] x:trust){
            result.add(x[1]);
        }
        
        // for(Integer y:result){
        //     System.out.print(y);
        // }
        
        if(result.size() == 1){
            return result.get(0);
        }
        int x = result.get(0);
        for(int i=1;i<result.size();i++){
            if(result.get(i) != x){
                return -1;
            }
        }
        
        return result.get(0);
        ***/
        
        /*** Using HASHMAP now***/
        
        int[] isTrusted = new int[n+1];
        for(int[] person : trust){
            isTrusted[person[0]]--;
            isTrusted[person[1]]++;
        }
        for(int i = 1;i < isTrusted.length;i++){
            if(isTrusted[i] == n-1) return i;
        }
        return -1;
        
    }
}