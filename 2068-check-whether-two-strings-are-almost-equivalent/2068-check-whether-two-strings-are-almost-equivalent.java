class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
      Map<Character,Integer> temp1=new HashMap<>();
        Map<Character,Integer> temp2=new HashMap<>();

        String s=word1+word2;

        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        char[] w3=s.toCharArray();

        for(char x:w1){
            temp1.put(x,temp1.getOrDefault(x,0)+1);
        }

        for(char x:w2){
            temp2.put(x,temp2.getOrDefault(x,0)+1);
        }



        for(char x:w3){
            if(!temp1.containsKey(x)){
                if(temp2.get(x) > 3) return false;
            }
            if(!temp2.containsKey(x)){
                if(temp1.get(x)>3) return  false;
            }
            if(temp1.containsKey(x) && temp2.containsKey(x)) {
                if (Math.abs(temp1.get(x) - temp2.get(x)) > 3) return false;
            }

        }

        return true;
    }
}