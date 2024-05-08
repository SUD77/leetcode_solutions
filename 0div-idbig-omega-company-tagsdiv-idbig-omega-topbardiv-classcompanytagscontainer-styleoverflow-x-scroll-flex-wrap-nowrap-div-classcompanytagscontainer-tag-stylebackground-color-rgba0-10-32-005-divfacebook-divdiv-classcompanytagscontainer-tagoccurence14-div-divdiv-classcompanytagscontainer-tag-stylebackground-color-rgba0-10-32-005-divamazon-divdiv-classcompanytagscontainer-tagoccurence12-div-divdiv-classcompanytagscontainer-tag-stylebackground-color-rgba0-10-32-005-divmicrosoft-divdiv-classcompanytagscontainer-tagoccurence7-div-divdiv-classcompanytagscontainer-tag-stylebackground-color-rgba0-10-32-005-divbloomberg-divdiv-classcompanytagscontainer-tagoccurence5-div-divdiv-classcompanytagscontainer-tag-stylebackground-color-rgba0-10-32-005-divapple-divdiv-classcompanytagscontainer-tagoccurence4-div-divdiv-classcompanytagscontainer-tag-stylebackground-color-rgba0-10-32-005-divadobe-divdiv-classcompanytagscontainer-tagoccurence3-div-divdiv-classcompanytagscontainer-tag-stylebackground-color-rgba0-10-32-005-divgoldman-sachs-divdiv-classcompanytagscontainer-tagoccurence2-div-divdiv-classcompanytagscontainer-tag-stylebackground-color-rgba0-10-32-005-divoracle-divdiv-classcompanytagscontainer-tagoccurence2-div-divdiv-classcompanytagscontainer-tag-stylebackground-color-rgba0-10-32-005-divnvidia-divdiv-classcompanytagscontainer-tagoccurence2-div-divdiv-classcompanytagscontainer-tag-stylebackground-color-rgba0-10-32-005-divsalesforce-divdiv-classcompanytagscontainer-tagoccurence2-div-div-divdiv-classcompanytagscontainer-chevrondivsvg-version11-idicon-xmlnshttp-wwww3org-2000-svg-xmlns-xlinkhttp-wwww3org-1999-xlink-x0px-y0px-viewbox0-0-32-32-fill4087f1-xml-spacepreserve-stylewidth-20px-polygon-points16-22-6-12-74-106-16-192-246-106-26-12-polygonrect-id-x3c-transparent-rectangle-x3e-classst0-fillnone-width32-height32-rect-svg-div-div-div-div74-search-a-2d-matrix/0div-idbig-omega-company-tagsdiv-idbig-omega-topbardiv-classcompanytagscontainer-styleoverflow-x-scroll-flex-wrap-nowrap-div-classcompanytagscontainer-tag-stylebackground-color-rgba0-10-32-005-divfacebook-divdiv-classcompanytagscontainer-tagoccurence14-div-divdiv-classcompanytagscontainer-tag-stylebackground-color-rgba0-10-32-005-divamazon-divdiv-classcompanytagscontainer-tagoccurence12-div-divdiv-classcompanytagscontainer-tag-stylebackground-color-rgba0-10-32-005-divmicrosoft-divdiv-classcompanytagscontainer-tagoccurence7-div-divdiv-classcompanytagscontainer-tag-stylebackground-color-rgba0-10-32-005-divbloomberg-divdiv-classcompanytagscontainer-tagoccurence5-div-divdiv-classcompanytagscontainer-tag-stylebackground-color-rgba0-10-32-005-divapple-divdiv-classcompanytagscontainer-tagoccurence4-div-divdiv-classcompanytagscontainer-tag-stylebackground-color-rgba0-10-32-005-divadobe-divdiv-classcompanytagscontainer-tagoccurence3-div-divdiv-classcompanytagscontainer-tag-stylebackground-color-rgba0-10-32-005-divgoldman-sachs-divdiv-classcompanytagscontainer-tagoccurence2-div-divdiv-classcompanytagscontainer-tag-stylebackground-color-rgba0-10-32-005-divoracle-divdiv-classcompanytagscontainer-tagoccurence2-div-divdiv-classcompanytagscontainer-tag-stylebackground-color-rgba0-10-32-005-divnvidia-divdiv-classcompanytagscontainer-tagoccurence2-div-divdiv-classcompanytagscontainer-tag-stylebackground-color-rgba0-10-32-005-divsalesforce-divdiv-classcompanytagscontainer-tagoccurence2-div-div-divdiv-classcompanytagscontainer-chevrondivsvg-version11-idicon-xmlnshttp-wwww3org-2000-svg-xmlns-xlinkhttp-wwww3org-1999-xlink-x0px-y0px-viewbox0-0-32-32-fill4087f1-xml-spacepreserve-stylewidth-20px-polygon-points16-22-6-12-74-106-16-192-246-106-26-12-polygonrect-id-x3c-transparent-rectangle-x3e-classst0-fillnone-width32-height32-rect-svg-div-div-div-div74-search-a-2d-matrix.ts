function searchMatrix(matrix: number[][], target: number): boolean {
    let row=matrix.length;
    let col=matrix[0].length;
    
    let i=0;
    let j=col-1;
    
    while(i<row && j>=0){
        if(matrix[i][j]==target) return true;
        else if(matrix[i][j]<target){
            i++;
        }else{
            j--;
        }
    }
    
    return false;
};