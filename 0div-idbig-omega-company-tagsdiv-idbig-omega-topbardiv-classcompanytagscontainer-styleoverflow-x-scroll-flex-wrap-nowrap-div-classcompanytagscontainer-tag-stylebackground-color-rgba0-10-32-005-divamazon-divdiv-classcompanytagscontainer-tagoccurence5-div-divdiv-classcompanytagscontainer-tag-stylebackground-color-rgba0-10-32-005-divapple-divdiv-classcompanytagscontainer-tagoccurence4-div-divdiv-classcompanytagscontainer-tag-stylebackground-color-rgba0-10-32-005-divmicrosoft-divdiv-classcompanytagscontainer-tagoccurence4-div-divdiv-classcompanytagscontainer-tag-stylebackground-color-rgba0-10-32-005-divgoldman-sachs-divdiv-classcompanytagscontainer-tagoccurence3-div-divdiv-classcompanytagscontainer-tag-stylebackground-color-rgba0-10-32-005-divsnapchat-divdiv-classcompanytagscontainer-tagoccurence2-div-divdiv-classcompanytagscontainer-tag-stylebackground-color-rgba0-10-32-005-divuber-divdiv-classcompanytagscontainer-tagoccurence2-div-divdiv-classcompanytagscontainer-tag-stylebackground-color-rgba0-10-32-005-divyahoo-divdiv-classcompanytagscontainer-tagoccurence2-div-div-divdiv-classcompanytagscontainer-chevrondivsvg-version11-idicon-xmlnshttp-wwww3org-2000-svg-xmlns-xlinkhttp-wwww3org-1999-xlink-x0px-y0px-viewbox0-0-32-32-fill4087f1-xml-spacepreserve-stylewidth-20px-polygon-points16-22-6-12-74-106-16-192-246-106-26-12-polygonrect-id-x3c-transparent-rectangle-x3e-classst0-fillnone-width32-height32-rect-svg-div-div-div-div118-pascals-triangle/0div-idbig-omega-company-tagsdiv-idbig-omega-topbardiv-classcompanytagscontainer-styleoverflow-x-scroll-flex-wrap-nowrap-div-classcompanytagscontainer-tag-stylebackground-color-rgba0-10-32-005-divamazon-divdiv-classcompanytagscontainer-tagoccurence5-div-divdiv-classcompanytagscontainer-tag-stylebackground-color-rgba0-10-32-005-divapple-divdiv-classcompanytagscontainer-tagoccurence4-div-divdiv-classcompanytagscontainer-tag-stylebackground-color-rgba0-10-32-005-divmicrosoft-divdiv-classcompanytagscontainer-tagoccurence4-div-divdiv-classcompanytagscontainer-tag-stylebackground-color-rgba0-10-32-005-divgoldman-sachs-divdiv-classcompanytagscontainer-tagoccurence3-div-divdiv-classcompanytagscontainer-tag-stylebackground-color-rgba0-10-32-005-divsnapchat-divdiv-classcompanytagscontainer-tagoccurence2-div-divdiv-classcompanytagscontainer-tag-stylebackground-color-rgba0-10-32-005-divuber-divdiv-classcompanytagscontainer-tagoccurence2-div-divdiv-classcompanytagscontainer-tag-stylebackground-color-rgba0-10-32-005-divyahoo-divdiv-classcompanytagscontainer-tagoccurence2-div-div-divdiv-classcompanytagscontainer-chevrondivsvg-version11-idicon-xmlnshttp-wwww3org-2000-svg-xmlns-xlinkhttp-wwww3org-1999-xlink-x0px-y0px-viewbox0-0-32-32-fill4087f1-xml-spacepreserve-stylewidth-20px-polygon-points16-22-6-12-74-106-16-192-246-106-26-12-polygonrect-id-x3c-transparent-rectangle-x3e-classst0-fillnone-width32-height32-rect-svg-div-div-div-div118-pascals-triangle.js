/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    
    let ans=[];
    
    for(let i=0;i<numRows;i++){
        
        let temp=[];
        
        for(let j=0;j<=i;j++){
            
            if(j==0 || j==i){
                temp.push(1);
            }else{
                temp.push(ans[i - 1][j] + ans[i - 1][j - 1]);
            }
        }
        
        ans.push(temp);
    }
    
    return ans;
    
    
    
};