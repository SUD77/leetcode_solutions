class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        StringBuilder[] rows=new StringBuilder[numRows];
        
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder("");
        }
        
        boolean isGoingDown=true;
        int rowidx=1;
        
        for(char c:s.toCharArray()){
            
            rows[rowidx-1].append(c);
            
            if(rowidx==1) isGoingDown=true;
            else if(rowidx==numRows) isGoingDown = false;
            
            if(isGoingDown) rowidx++;
            else rowidx--;
            
        }
        
        StringBuilder ans=new StringBuilder();
        
        for(StringBuilder r: rows){
            ans.append(r);
        }
        
        return ans.toString();
    }
}