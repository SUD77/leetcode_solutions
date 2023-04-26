/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int low=0, high=n;
        
        while(low+1<high){
            
            int mid=low+(int)Math.floor((high-low)/2);
            
            if(isBadVersion(mid)){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        return high;
    }
}