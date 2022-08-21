class Solution {
    public String largestPalindromic(String num) {
        
         StringBuilder sb=new StringBuilder();
            
        // To store count of digits
         TreeMap<Character,Integer> map=new TreeMap<>();

        
        /* List too :  for stroing key value pair whose count are divisible by 2.
            List onn: for stroing other counts
        */
         List<Map.Entry<Character,Integer>> too=new ArrayList<>();
         List<Map.Entry<Character,Integer>> onn=new ArrayList<>();

        //Putting values in map
         for(int i=0;i<num.length();i++){
             map.put(num.charAt(i),map.getOrDefault(num.charAt(i),0)+1);
         }

        
        //From map, putting values in list
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


        //Sorting both list by key values. In decreasing order.
        Collections.sort(too,(i1,i2)-> i2.getKey().compareTo(i1.getKey()));
        Collections.sort(onn,(i1,i2)-> i2.getKey().compareTo(i1.getKey()));


        //This will form the half palindrome list. And this only goes thorugh list too. 
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

        
        //Reversing the sb String
        StringBuilder revSB=new StringBuilder(sb);

        //From onn list, we add the highest key in sb
        if(onn.size()>0){
            sb.append(onn.get(0).getKey());
        }


        //appendig the reverse of sb
        sb.append(revSB.reverse());

        //If sb is empty, return "0". This is for test cases like "0000"
        if(sb.toString().length()==0) return "0";
        
         return sb.toString();
    }
}