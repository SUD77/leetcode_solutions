class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> ans=new ArrayList<>();

        List<List<Integer>> temp=new ArrayList<>();


        for(int j=0;j<= groupSizes.length;j++){
            temp.add(j,new ArrayList<>());
        }

        for(int i=0;i<groupSizes.length;i++){


            temp.get(groupSizes[i]).add(i);
        }

        for(int i=0;i<temp.size();i++){

            if(temp.get(i).size() > i){

                int tempVal=temp.get(i).size();
                
                int q=0;

                while (q<tempVal){
                    ans.add(temp.get(i).subList(q,q+i));
                    q=q+i;
                }
            }else{
                if(!temp.get(i).isEmpty())ans.add(temp.get(i));
            }
        }




        return ans;
    }
}