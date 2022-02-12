import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        List<String> tempArr=new ArrayList<String>();
        
        Map<String,Integer> temp=new HashMap<String,Integer>();
        Map<String,Integer> temp2=new HashMap<String,Integer>();
        for(int i=0;i<list1.length;i++){
            if(!temp.containsKey(list1[i])){
                temp.put(list1[i],i);
            }
        }
        
        //System.out.println(temp);
        
        for(int j=0;j<list2.length;j++){
            if(temp.containsKey(list2[j])){
                temp2.put(list2[j],temp.get(list2[j]) + j);
            }
        }
                
                
        //System.out.println(temp2);
        
        int min=Integer.MAX_VALUE;
       
        
        for(Map.Entry<String,Integer> set:temp2.entrySet()){
            if(min>=set.getValue()) {
                min=set.getValue();
                
            }
        }
        
         for(Map.Entry<String,Integer> set:temp2.entrySet()){
            if(min==set.getValue()) {
                tempArr.add(set.getKey());
                
            }
        }
        
        
        
         String[] result=new String[tempArr.size()];
        int k=0;
        
        for(String x:tempArr){
            result[k++]=x;
        }
       
        
        return result;
        
        
    }
}