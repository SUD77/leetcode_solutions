class Solution {
    public String pushDominoes(String dominoes) {
       
        char[] domino=dominoes.toCharArray();
        int N=domino.length;
        int[] forces=new int[N];
        
        int force=0;
        for(int i=0; i<N;i++){
            
            if(domino[i]=='R'){
                force=N;
            }else if(domino[i]=='L'){
                force=0;
            }else {
                force = Math.max(force-1,0);
            }
            forces[i] +=force;
        }
        
        force=0;
        
        for(int i=N-1; i>=0; i--){
            
            if(domino[i]=='L'){
                force=N;
            }else if(domino[i]=='R'){
                force=0;
            }else{
                force=Math.max(force-1,0);
            }
            
            forces[i]-=force;
        }
        
        StringBuilder result=new StringBuilder();
        
        for(Integer f: forces){
            
            if(f>0){
                result.append('R');
            }else if(f<0){
                result.append('L');
            }else{
                result.append('.');
            }
        }
        
        return result.toString();
    }
}