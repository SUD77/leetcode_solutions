/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let n=nums.length;
  // console.log(n);
  k=k%n;

  reverseArr(nums,0,n-1);
  reverseArr(nums,0,k-1);
  reverseArr(nums,k,n-1);

  // console.log(nums);
};


var reverseArr= function(nums,start,end) {

  while(start<end){

    let temp=nums[end];
    nums[end]=nums[start];
    nums[start]=temp;

    start++;
    end--;
  }
}