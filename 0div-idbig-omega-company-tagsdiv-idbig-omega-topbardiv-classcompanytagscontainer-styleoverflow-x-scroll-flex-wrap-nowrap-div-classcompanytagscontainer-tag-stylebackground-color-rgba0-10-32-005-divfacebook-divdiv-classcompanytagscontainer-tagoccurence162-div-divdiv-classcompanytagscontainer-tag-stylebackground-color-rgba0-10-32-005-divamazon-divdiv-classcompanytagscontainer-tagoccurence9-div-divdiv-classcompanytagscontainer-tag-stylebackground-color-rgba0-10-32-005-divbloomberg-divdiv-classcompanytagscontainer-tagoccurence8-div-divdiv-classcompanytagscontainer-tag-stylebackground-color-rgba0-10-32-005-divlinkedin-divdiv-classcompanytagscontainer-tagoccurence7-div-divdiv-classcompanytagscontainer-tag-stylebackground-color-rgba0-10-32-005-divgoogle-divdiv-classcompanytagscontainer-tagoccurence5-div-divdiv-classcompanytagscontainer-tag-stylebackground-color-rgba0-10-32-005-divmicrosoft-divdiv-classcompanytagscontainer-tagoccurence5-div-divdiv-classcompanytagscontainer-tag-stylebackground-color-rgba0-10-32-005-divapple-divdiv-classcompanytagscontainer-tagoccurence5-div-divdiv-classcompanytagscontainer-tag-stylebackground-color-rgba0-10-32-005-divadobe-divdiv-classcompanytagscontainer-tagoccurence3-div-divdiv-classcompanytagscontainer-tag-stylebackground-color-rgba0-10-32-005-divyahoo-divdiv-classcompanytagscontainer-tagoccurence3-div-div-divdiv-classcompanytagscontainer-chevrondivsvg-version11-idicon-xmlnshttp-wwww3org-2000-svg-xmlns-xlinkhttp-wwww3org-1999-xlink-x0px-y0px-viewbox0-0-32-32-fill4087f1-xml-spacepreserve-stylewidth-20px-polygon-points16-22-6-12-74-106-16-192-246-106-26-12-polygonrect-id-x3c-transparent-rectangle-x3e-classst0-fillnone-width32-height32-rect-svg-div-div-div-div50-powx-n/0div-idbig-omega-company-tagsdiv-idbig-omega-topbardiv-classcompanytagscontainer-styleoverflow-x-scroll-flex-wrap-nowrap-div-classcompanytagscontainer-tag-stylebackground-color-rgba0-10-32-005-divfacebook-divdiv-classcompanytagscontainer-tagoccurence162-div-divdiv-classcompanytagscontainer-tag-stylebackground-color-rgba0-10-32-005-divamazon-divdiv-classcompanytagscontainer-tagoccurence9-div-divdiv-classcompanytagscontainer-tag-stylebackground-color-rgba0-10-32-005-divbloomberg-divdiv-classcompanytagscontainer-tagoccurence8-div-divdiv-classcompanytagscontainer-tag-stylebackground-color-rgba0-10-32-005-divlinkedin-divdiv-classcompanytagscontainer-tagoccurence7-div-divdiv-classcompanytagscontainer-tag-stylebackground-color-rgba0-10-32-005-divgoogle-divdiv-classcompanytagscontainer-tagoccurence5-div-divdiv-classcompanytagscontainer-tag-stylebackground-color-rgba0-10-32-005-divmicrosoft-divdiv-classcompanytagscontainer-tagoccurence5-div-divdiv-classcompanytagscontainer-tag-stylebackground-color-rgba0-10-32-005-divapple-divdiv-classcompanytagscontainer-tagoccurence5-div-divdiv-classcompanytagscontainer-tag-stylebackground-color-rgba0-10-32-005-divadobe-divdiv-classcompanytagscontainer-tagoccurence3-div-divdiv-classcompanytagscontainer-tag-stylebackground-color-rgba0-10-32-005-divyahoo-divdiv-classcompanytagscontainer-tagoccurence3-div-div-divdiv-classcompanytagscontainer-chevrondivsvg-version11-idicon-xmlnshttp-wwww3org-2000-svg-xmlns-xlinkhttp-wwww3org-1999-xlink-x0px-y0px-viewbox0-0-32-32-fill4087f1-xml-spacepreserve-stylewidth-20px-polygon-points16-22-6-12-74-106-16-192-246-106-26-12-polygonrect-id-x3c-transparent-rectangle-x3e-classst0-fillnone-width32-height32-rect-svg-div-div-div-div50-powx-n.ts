function myPow(x: number, n: number): number {
    
    let ans=1.0;
    let tempN=n;
    
    if(tempN<0) tempN=(-1)*tempN;
    
    while(tempN>0){
          
        if(tempN%2==1){
           ans=ans*x;
            tempN=tempN-1;
           }
        else{
            x=x*x;
            tempN=tempN/2;
        }
    }
    
    if(n<0) ans=1.0/ans;
    
    return ans;
    
};