class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n=s.length();
        
        int[] shift=new int[s.length()+1];

         for(int i=0;i<shifts.length;i++){

             int start=shifts[i][0];
             int end=shifts[i][1];

//              for(int x=start;x<=end;x++){
//                  if(shifts[i][2]==0){

//                      shift[x]=(shift[x]-1)%26;

//                  }else{
//                      shift[x]=(shift[x]+1)%26;

//                  }
//              }
             
                         
                 if(shifts[i][2]==0){

                    shift[start]--;
                    shift[end+1]++;

                 }else{
                     shift[start]++;
                     shift[end+1]--;

                 }
 
         }
        
        System.out.println(Arrays.toString(shift));

        char[] result=s.toCharArray();
  

        int sum=0;
        
        for(int i=0;i<n;i++){
            
            sum+=shift[i];
            int k=sum%26;
            int p=(result[i]-'a'+k+26)%26;
            result[i]=(char)('a'+p);
        }


         return new String(result);
    }
}