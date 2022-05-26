class Solution {
    public int numUniqueEmails(String[] emails) {
        
        if(emails == null){
            return 0;
        }
        
        /*Logic used : First break the String around "@", to get local and domain. Then
        in local, check if it contains "+" or not. These will be 2 cases. And within two cases
        , check if the substring contain ".". Replace "." with "" and add everything to 
        StringBuilder.*/
        
        
        HashSet<String> finalResult=new HashSet<>();

        for(String x:emails){

            StringBuilder sb=new StringBuilder();

            //Splitting the string around "@". temp[0] is local and temp[1] is domain.
            String[] temp=x.split("@");

            
            if(temp[0].contains("+")) {
                String[] temp2 = temp[0].split("\\+");

                if(temp2[0].contains(".")){
                    temp2[0]=temp2[0].replace(".","");
                    sb.append(temp2[0]);
                }else{
                    sb.append(temp2[0]);
                }

            }else{
                if(temp[0].contains(".")){
                    temp[0]=temp[0].replace(".","");
                    sb.append(temp[0]);
                }else{
                    sb.append(temp[0]);
                }

            }
            sb.append("@");
            sb.append(temp[1]);
            finalResult.add(sb.toString());

        }
        
        return finalResult.size();
    }
}