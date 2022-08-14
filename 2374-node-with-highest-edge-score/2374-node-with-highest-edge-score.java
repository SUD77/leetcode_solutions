class Solution {
    public int edgeScore(int[] edges) {
        
        HashMap<Integer,Long> temp=new HashMap<>();

        for(int i=0;i< edges.length;i++){

            temp.put(edges[i],temp.getOrDefault(edges[i],(long)0)+(long)i);
        }

        System.out.println(temp);

        Long maxValue=(long)0;
        int res=0;
        for(Map.Entry<Integer,Long> ele:temp.entrySet()){
            int key=ele.getKey();
            Long val=ele.getValue();

            //maxValue=Math.max(maxValue,val);

            if(val>maxValue){
                maxValue=val;
                res=key;
            }
        }
        
        
        return res;
    }
}