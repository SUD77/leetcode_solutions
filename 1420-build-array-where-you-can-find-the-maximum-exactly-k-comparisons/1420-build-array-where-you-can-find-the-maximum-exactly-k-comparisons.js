/**
 * @param {number} n
 * @param {number} m
 * @param {number} k
 * @return {number}
 */

// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/discuss/4140183/Simple-Javascript-solution


var numOfArrays = function(n, m, k) {
    
    const cache={};
    
    const dfs = (maxValue, costRemaining, len) => {
        
        if(costRemaining < 0) return 0;
        
        if(len == n) return costRemaining ? 0 : 1;
        
        const key=[maxValue, costRemaining, len].join('-')
        
        if(cache[key]!==undefined) return cache[key];
        len++;
        
        let total=0;
        
        for(let i=1;i<=m;i++){
            const nextCostRem = costRemaining - (i > maxValue ? 1:0);
            total+= dfs(Math.max(i,maxValue), nextCostRem,len);
        }
        
        return cache[key]=total%1000000007;
    }
    
    return dfs(-1,k,0);
    
};