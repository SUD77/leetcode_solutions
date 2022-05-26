class Solution {
    public int numUniqueEmails(String[] emails) {
        
        if(emails == null){
            return 0;
        }
        
        List<String> result=new ArrayList<>();
        HashSet<String> finalResult=new HashSet<>();

        for(String x:emails){

            StringBuilder sb=new StringBuilder();

            String[] temp=x.split("@");

            //Splitting around +. temp2[0] and temp2[1]
            if(temp[0].contains("+")) {
                String[] temp2 = temp[0].split("\\+");

                if(temp2[0].contains(".")){
//                    String[] temp3=temp2[0].split("\\.");
//                    sb.append(temp3[0]);
//                    sb.append(temp3[1]);
                    temp2[0]=temp2[0].replace(".","");
                    sb.append(temp2[0]);
                }else{
                    sb.append(temp2[0]);
                }

            }else{
                if(temp[0].contains(".")){
//                    String[] temp3=temp[0].split("\\.");
//                    sb.append(temp3[0]);
//                    sb.append(temp3[1]);
                    temp[0]=temp[0].replace(".","");
                    sb.append(temp[0]);
                }else{
                    sb.append(temp[0]);
                }

            }
            sb.append("@");
            sb.append(temp[1]);
            result.add(sb.toString());

        }

        result.forEach( x -> finalResult.add(x));

        // System.out.println(finalResult.size());
        
        return finalResult.size();
    }
}