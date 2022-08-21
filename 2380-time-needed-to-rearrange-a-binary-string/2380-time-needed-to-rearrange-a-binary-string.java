class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count=0;
        
        char arr[]=s.toCharArray();
        
        int n=arr.length;
        
        while(true){
            
            boolean flag=false;
            
            for(int i=0;i<n-1;i++) {
             
                if(arr[i]=='0' && arr[i+1]=='1'){
                    
                    flag=true;
                    arr[i]='1';
                    arr[i+1]='0';
                    i++;
                }
                
            }
            
            if(flag==true) count++;
            if(isValid(arr)==true) break;
        }
        
        return count;
    }
    
    private static boolean isValid(char[] arr){
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]=='0' && arr[i+1]=='1') return false;
        }
        
        return true;
    }
}