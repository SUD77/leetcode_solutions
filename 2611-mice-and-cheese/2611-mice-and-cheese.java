class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        
       List<Pair> ans=new ArrayList<>();
        int result=0;

        for(int i=0;i<reward1.length;i++){
            ans.add(new Pair(reward1[i]-reward2[i],i));
        }


        Collections.sort(ans, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.key-o1.key;
            }
        });

        for(int i=0;i<k;i++){
            result+= reward1[ans.get(i).value];
        }

        for(int i=k;i<ans.size();i++){
            result+=reward2[ans.get(i).value];
        }


        return result;
    }

    class Pair{
        int key;
        int value;

        Pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}