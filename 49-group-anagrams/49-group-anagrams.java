class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
         List<List<String>> ans=new ArrayList<>();

         Map<String,List<String>> map=new HashMap<>();

         for(int i=0;i<strs.length;i++){

             String temString=strs[i];
             char[] tempArr=strs[i].toCharArray();
             Arrays.sort(tempArr);
             String tempS=String.valueOf(tempArr);
             
             if(!map.containsKey(tempS)){
                 map.put(tempS,new ArrayList<String>());
             }
             map.get(tempS).add(temString);



         }

        for(Map.Entry<String,List<String>> ele:map.entrySet()){
            ans.add(ele.getValue());
        }


         return ans;
        
    }
}