/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let accumulator = init;
    
    nums.forEach( (x)=> {
        accumulator = fn(accumulator,x);
    });
    
    return accumulator;
};