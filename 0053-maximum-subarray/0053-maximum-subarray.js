/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    
    let maxSum=nums[0];
    let sum=0;
    
    for(let i=0;i<nums.length;i++){
        
        sum+=nums[i];
        maxSum=Math.max(maxSum,sum);
        // console.log(maxSum);
        if(sum<0){
            sum=0;
        }
        
    }
    
    // console.log(maxSum);
    return maxSum;
};