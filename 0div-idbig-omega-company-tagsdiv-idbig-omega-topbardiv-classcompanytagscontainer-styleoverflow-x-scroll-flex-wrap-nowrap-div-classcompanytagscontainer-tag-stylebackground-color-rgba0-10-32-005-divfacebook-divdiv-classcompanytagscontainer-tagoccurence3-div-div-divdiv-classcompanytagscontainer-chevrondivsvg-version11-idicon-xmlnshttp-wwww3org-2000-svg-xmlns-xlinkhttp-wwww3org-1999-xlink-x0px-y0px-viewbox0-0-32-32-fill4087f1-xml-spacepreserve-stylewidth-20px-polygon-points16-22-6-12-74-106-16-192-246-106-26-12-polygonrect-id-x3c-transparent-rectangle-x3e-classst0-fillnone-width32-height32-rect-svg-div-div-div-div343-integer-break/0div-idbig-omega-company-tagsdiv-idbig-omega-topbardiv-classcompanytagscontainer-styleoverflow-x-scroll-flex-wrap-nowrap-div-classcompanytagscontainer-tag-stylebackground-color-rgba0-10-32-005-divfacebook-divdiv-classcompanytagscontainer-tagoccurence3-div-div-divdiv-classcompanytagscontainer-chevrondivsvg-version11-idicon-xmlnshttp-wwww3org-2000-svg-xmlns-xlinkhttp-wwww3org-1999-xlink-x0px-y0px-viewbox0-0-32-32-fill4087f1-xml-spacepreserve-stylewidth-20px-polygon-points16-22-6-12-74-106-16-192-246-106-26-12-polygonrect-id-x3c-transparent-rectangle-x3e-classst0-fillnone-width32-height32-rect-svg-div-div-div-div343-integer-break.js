/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {
    let parts=2
    let result=1
    
    let newResult
    
    while(Math.round(n/parts) >=2){
        newResult=calc(n,parts)
        
        if(newResult > result){
            result=newResult
        }
        
        parts++;
    }
    
    return result
};


function calc(n,parts){
    let prod=Math.round(n/parts)
    let last=prod+(n - prod * parts)
    
    return Math.pow(prod,parts-1) * last
}