class Solution {
    public int[] finalPrices(int[] prices) {
        
        
        int[] result=new int[prices.length];
        int k=0;
        
        /*To check if get if we the discount price or not, it not, then check will be
        false and then, the price without discount will be added to the result array.*/
        boolean check=false;


        for(int i=0;i<prices.length-1;i++){

            for(int j=i+1;j< prices.length;j++){

                if(prices[j]<= prices[i]){
                    result[k++]= prices[i]-prices[j];
                    check=true;
                    break;
                }
            }

            if(check!=true){
                result[k++]=prices[i];
            }
            check=false;

        }

        /*Adding the last element of price array to result array, as out outer loop
        ignored the last element of price array*/
        result[k]=prices[prices.length-1];
        
        return result;
    }
}