class Solution {
    public int lengthOfLastWord(String s) {
        
        //Spliting the String in String array containing each Word. 
        String[] temp=s.split(" ");

        int size=temp.length;
        
        //returning the last word's length in temp array.
        return (temp[size-1].length());
    }
}