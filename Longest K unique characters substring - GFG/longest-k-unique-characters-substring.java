//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        int n=s.length();
        int answer=-1;
        
        int i=0;
        int j=0;
        
        //Map to store the frequency of each character
        HashMap<Character,Integer> map=new HashMap<>();
        
        
        while(j<n){
            
            //Sliding window calculations
            char ch=s.charAt(j);
            
            //get the freq of ch from Map and increase it by 1
            // if it doensnt exist, enter it in map
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            
            //Sliding Window Condition: hashmap.size = k  [OR number of Unique Characters =k];
            
            if(map.size()>k){
                
                /*Reduce the frequency of ith element by 1 and remove it from map if frequency becomes 0.
                Keep doing above [reducing window size] till hm.size becomes <=k  */
                
                while(map.size()>k){
                    
                    char currChar=s.charAt(i);
                    
                    map.put(currChar,map.get(currChar)-1);
                    
                    if(map.get(currChar)==0) map.remove(currChar);
                    
                    i++;
                }
                
            }
            
            
            //unique chars = k , compute candidate answer.
            if(map.size()==k){
                int currAns=j-i+1;
                answer=Math.max(answer,currAns);
            }
            
             // increase window size and look for next window where sum = target
            j++;
            
            
        }
        
        
        return answer;
    }
}