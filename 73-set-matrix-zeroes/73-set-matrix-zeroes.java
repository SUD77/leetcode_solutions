class Solution {
    public void setZeroes(int[][] matrix) {
        
        ArrayList<Integer>[] tempMap=new ArrayList[matrix.length];

        for(int i=0;i<matrix.length;i++){
            tempMap[i]=new ArrayList<>();
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    tempMap[i].add(j);
                }
            }
        }

        for(int i1=0;i1< tempMap.length;i1++){

            int c=0;
            while(c<tempMap[i1].size() && !tempMap[i1].isEmpty()){
                int x=tempMap[i1].get(c++);

                for(int i=0;i< matrix.length;i++){
                    matrix[i][x]=0;
                }

                for(int i=0;i<matrix[0].length;i++){
                    matrix[i1][i]=0;
                }

            }
        }

        
    }
}