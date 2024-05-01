function merge(intervals: number[][]): number[][] {
    
    intervals.sort((a,b) => a[0]-b[0]);
    
    let start=intervals[0][0];
    let end=intervals[0][1];
    
    const tempAns:number[][]=[];
    
    for(const interval of intervals){
        const tempList: number[]=[];
        
        const tempStart=interval[0];
        const tempEnd=interval[1];
        
        if(tempStart<=end){
            end=Math.max(end,tempEnd);
        }else{
            
            tempList.push(start);
            tempList.push(end);
            tempAns.push(tempList);
            
            start=tempStart;
            end=tempEnd;
        }
    }
    
    
    //Addng the last element
    const tempList: number[]=[];
    
    tempList.push(start);
    tempList.push(end);
    tempAns.push(tempList);
    
    const ans: number[][]=new Array(tempAns.length);
    let i=0;
    
    for(const interval of tempAns){
        ans[i]=[interval[0],interval[1]];
        i++;
    }
    
    return tempAns;
    
};