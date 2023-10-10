// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/discuss/1697881/Javascript-Sliding-Window

/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    
    if(nums.length==0) return 0;
    
    let n=nums.length;
    
    nums.sort((a,b) => a-b);
    
    let m=1;
    
    for(let i=1;i<n;i++){
        if(nums[i]!=nums[i-1]){
            nums[m]=nums[i];
            m++;
        }
    }
    
    let i=0;
    let j=0;
    
    for(j=0;j<m;j++){
        
        if(nums[i] + n <= nums[j]){
            i++;
        }
    }
    
    return  n-m+i;
    
};