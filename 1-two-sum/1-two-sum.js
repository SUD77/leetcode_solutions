/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

/*
To read : 
1. Map - https://www.w3schools.com/js/js_maps.asp
2. Arrays - https://www.w3schools.com/js/js_arrays.asp

*/
var twoSum = function(nums, target) {
    let map=new Map();
    
    for(let i=0;i<nums.length;i++){
        
        if(map.has(target-nums[i])){
            return [map.get(target - nums[i]),i];
        }else {
            map.set(nums[i],i);
        }
        
    }
    
    return [];
};