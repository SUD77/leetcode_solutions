function findDuplicate(nums: number[]): number {
    
    let countArr: number[]=new Array(nums.length).fill(0);;
    let ans : number=0;
    
    
    for(let i=0;i<nums.length;i++){
        countArr[nums[i]]++;
    }
    
    // console.log(countArr);
    
    for(let i=0;i<countArr.length;i++){
        if(countArr[i]>=2) {
            // console.log(nums[i]);
            ans=i;
            break;
        }
    }
    
    return ans;
};