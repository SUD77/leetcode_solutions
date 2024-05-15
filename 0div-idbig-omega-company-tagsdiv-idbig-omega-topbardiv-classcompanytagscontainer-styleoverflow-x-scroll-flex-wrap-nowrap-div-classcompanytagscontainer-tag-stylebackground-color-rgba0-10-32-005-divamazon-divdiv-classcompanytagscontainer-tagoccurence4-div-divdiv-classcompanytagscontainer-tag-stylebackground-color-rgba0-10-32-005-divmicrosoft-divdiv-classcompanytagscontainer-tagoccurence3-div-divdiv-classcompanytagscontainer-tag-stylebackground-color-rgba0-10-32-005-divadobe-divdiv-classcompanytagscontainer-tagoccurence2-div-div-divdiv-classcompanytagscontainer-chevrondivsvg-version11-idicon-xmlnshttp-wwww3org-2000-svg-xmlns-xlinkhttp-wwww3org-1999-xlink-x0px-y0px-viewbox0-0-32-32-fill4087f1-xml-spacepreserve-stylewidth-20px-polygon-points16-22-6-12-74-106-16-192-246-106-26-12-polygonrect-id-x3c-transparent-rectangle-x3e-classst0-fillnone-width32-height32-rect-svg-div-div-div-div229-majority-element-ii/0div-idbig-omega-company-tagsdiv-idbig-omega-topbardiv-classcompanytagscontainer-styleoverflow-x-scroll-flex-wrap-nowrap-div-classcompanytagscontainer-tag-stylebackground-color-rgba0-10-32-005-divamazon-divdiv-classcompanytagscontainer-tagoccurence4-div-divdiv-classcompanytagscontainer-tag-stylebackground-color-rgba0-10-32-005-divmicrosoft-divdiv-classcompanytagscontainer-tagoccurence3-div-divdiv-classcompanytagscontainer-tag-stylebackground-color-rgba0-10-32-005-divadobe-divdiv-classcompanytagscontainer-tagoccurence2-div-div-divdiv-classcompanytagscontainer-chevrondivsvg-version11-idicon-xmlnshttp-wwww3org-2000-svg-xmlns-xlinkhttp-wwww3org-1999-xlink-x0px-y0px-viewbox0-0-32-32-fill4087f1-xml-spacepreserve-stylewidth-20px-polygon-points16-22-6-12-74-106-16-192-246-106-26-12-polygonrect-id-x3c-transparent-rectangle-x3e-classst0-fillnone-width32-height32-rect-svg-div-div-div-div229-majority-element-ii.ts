function majorityElement(nums: number[]): number[] {
    
    let n=nums.length;
    
    let ans: number[]=[];
    
    let map=new Map<number,number>();
    
    for(let x of nums){
        
        if(!map.has(x)){
            map.set(x,0);
        }
        
        map.set(x,map.get(x)!+1);
    }
    
    for(let x of nums){
        if(map.get(x) > n/3){
            if(!ans.includes(x)) ans.push(x);
        }
    }
    
    return ans;
    
    
};