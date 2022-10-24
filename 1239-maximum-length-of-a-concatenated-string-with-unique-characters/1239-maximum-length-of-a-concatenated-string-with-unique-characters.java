class Solution {
    
    int max=0;
    
    public int maxLength(List<String> arr) {
    
        backtrack(arr,"",0);
        return max;
    }
    
    private void backtrack(List<String> arr,String current,int start){
        
        if(max<current.length())
            max=current.length();
        
        for(int i=start; i<arr.size(); i++){
            
            if(!isValid(current,arr.get(i))) continue;
            backtrack(arr,current+arr.get(i),i+1);
        }
    }
    
    private boolean isValid(String curS,String newS){
        
        int[] arr=new int[26];
        
        for(int i=0;i<newS.length();i++){
            
            if(++arr[newS.charAt(i)-'a']==2) return false;
            
            if(curS.contains(newS.charAt(i)+""))
                return false;
        }
        
        return true;
    }
}