class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0; int j = mat.length - 1; int sum = 0; for(int k = i; k <= j; k++) { sum += mat[k][k] + mat[j - k][k]; } if(mat.length % 2 == 1) { sum -= mat[mat.length/2][mat.length/2]; } return sum;
        
    }
}