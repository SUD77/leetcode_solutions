class Solution {
    public String frequencySort(String s) {
        
        char[] c=s.toCharArray();

        Map<Character,Integer> temp= new HashMap<>();

        for(int i=0;i<c.length;i++){
            temp.put(c[i],temp.getOrDefault(c[i],0)+1);
        }

        List<Character>[] buket=new List[s.length()+1];

        for(char key:temp.keySet()){

            int freq=temp.get(key);
            if(buket[freq]==null) buket[freq] = new ArrayList<>();
            buket[freq].add(key);
        }

        StringBuilder sb=new StringBuilder();

        for(int pos= buket.length-1;pos>=0;pos--){
            if(buket[pos]!=null){
                for(char ch:buket[pos]){
                    for(int i=0;i<pos;i++){
                        sb.append(ch);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}