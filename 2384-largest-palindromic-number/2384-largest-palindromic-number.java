class Solution {
    public String largestPalindromic(String num) {
        
         StringBuilder sb=new StringBuilder();

         TreeMap<Character,Integer> map=new TreeMap<>();

         List<Map.Entry<Character,Integer>> too=new ArrayList<>();
         List<Map.Entry<Character,Integer>> onn=new ArrayList<>();

         for(int i=0;i<num.length();i++){
             map.put(num.charAt(i),map.getOrDefault(num.charAt(i),0)+1);
         }

         for(Map.Entry<Character,Integer> ele:map.entrySet()){


             if(ele.getValue()%2==0 ){
                 too.add(ele);
             }else{

                 if(ele.getValue()>1){
                     too.add(ele);
                     onn.add(ele);
                 }else{
                     onn.add(ele);
                 }

             }
         }


        Collections.sort(too,(i1,i2)-> i2.getKey().compareTo(i1.getKey()));
        Collections.sort(onn,(i1,i2)-> i2.getKey().compareTo(i1.getKey()));


        for(Map.Entry<Character,Integer> ele:too){

            int t=ele.getValue()/2;

            if(ele.getKey()=='0' && sb.length()!=0){


                    while(t>0){
                        sb.append(ele.getKey());
                        t--;

                    }
            }else if(ele.getKey()!='0'){
                while(t>0){
                    sb.append(ele.getKey());
                    t--;
                }
            }

        }

        
        StringBuilder revSB=new StringBuilder(sb);

        if(onn.size()>0){
            sb.append(onn.get(0).getKey());
        }


        sb.append(revSB.reverse());

        if(sb.toString().length()==0) return "0";
         return sb.toString();
    }
}