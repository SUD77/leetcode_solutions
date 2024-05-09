function majorityElement(nums: number[]): number {
    
    let ans=0;
    
    let map=new Map<number,number>();
    
    for(let x of nums){
        
        if(!map.has(x)){
            map.set(x,0);
        }
        map.set(x,map.get(x)!+1);
    }
    
    // console.log(map);
    let tempCount=0;
    
    for(let x of nums){
        
        if(map.get(x)>=tempCount){
            tempCount=map.get(x);
            ans=x;
        }
    }
    
    return ans;
    
};