class Solution {
    public boolean isUgly(int n) {
        
        if(n<=0) return false;
        if(n==1) return true;
        
         HashSet<Integer> result=new HashSet<>();
         prim(n,result);

         if(result.size()>3) System.out.println("fasle");

        
        for(Integer x:result){
         if(x>5 || x==4) return false;
        }


        return true;

    }
    
    
    public void prim(int n,HashSet<Integer> result){

        for (int i = 2; i <= Math.sqrt(n); i += 1) {
            // While i divides n, print i and divide n
            while (n % i == 0) {

                result.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)

            result.add(n);

    }
    
    
}