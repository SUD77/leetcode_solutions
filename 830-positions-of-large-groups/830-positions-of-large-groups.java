class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
         List<List<Integer>> res=new ArrayList<>();

        int start=0;
        int end=0;

        for(int i=0;i<s.length();i++){

            if(i>0){
                if(s.charAt(i)==s.charAt(i-1)) {
                    
                    if(i==s.length()-1){
                       end=i;
                        
                        if((end-start+1)>=3){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(start);
                        temp.add(end);
                        res.add(temp);
                        }
                    }
                    end=i;
                }
                else if(s.charAt(i)!=s.charAt(i-1)){

                    if((end-start+1)>=3){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(start);
                        temp.add(end);
                        res.add(temp);
                    }


                    start=i;

                }
            }
        }


        return res;
    }
}