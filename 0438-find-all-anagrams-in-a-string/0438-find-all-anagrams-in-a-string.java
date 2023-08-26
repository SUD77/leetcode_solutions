// https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        
        List<Integer> ans=new ArrayList<>();
        
        int k=p.length();   //window size
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        
        //putting all char of String p in map
        for(int i=0;i<k;i++){
            char ch=p.charAt(i);
        
            map.put(ch,map.getOrDefault(ch,0)+1);
            
        }
        
        
        // it tracks no key left in map
        int count=map.size();
        
        int i=0,j=0;
        
        while(j<s.length()){
            
            char ch=s.charAt(j);
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                
                
                //if that key is not anymore in map, decrease count
                if(map.get(ch)==0) count--;
            }
            
            
            // till less than window size
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                
                if(count==0) ans.add(i);
                
                char ch1=s.charAt(i);
                
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1)+1);
                    
                    if(map.get(ch1)==1){
                        count++;
                    }
                }
                
                i++;
                j++;
            }
        }
        
        
        return ans;
    }
}