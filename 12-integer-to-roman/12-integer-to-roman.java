class Solution {
    public String intToRoman(int num) {
     
        HashMap<String,Integer> map=new LinkedHashMap<>();
        
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        
        
        StringBuilder sb=new StringBuilder();
        for(String val:map.keySet()){
            
            while(num-map.get(val)>=0){
                sb.append(val);
                num=num-map.get(val);
            }
        }
        
        return sb.toString();
    }
}