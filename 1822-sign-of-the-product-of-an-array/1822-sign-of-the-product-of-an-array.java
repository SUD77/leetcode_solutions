class Solution {
    public int arraySign(int[] nums) {
//         long prod=1;
//         for(int x:nums){
//             prod *=x;
//         }
        
//         System.out.println(prod);
//         return signFunc(prod);
//     }
    
//     public int signFunc(long product){
//         if(product > 0) return 1;
//         else if(product < 0) return -1;
        
//         return 0;
//     }
     
        int sign=1;
        for(int n : nums) {
            
            if(n==0) return 0;
            if(n < 0) sign = -sign;
        }
        
        return sign;
    }
}