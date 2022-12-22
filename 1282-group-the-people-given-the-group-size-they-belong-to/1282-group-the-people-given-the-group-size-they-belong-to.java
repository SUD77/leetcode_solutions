class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> ans=new ArrayList<>();

        
        //temp arary to store the elements in there respective group sizes
        List<List<Integer>> temp=new ArrayList<>();

     
        //Assigning each group size no a Empty arrayList
        for(int j=0;j<= groupSizes.length;j++){
            temp.add(j,new ArrayList<>());
        }

        
        //Putting elements in there repsective group size
        for(int i=0;i<groupSizes.length;i++){

            temp.get(groupSizes[i]).add(i);
        }

        
        /*
        Here, we will fill ans list.
        If 6 people are in group size of 3, so in if condition,
        we create 2 sublist of 3 size and add them in ans.
        Simliarly for other sizes. 
        
        */
        for(int i=0;i<temp.size();i++){

            if(temp.get(i).size() > i){

                int tempVal=temp.get(i).size();
                
                int q=0;

                while (q<tempVal){
                    ans.add(temp.get(i).subList(q,q+i));
                    q=q+i;
                }
            }else {
                if(!temp.get(i).isEmpty())ans.add(temp.get(i));
            }
        }

        return ans;
    }
}