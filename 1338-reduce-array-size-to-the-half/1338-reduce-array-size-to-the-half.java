class Solution {
    public int minSetSize(int[] arr) {
        
        
        int n=arr.length;
        int count=0;
        int check=n;
            
        HashMap<Integer,Integer> temp=new HashMap<>();
        List<Map.Entry<Integer, Integer>> arrValues=new ArrayList<>();
        LinkedHashMap<Integer,Integer> linkedMap=new LinkedHashMap<>();
        
        for(int x:arr){
            temp.put(x,temp.getOrDefault(x,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> ele:temp.entrySet()){
            arrValues.add(ele);
        }
        
        Collections.sort(arrValues,new listSorter());
        
        for(Map.Entry<Integer,Integer> ele:arrValues){
            check=check-ele.getValue();
            count++;
            if(check<=n/2) break;
            //linkedMap.put(ele.getKey(),ele.getValue());
        }
        
        
        //System.out.println(count);
        
        
        
        return count;
        
        
    }
    
    public class listSorter implements Comparator<Map.Entry<Integer,Integer>>{
        
        @Override
            public int compare(
                  Map.Entry<Integer, Integer> e1,
                  Map.Entry<Integer, Integer> e2) {

                Integer int1 = e1.getValue();
                Integer int2 = e2.getValue();
                return int2.compareTo(int1);
            }
    }
}