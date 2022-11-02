class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        // first check
        if(start.equals(end)) return 0;
        
        Set<String> bankStrSet=new HashSet<>();
        
        //Storing strings of bank array in set
        for(String str:bank){
            bankStrSet.add(str);
        } 
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int mutations=0;
        
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            
            int size=queue.size();
            
            while(size-- > 0){
                
                String curStr=queue.poll();
                
                if(curStr.equals(end)) return mutations;
                
                char[] curStrArray=curStr.toCharArray();
                
                for(int i=0;i<curStrArray.length;i++){
                    
                    char oldChar=curStrArray[i];
                    
                    for(char c:charSet){
                        
                        curStrArray[i]=c;
                        
                        //converting the char array in String after making changes
                        String next=new String(curStrArray);
                        
                        if(!visited.contains(next) && bankStrSet.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    //Setting back the oldChar in place to reverse the change. 
                    curStrArray[i]=oldChar;
                }
                
            }
            mutations++;
        }
        
        return -1;
    }
}