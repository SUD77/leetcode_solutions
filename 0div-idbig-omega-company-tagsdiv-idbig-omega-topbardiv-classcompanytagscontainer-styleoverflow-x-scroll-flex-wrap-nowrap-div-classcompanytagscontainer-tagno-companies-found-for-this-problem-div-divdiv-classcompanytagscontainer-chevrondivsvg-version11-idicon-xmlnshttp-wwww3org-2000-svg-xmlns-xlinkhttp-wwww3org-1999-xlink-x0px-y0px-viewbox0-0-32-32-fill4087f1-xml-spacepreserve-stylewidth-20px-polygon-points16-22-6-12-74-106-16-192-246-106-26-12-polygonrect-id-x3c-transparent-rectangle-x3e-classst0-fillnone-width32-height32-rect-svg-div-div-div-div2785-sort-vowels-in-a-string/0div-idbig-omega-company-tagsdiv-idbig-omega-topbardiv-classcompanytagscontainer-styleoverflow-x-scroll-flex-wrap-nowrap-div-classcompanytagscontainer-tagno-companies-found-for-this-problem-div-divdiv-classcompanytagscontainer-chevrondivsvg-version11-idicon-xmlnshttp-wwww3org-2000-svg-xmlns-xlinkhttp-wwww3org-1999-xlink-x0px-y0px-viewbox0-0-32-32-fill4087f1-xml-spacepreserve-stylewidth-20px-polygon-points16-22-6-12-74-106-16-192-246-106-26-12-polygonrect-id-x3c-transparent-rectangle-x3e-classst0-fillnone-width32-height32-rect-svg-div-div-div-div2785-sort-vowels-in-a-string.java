/*

-  We create a stringbuilder with #.
-  We iterated over the string, and put consonants in stringbuilder (in place of #).
- Than we put all the vowels in string in a list and sort by acii
- Again, we iterate over, stringbuilder and put back vowels at the vowels position. 

*/



class Solution {
    public String sortVowels(String s) {
        StringBuilder ans=new StringBuilder();

        // Put all the charactes in string as #
        for(char x:s.toCharArray()){
            ans.append('#');
        }

        List<Character> list=new ArrayList<>();

        // Keeping all vowels in a set. 
        Set<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        for(int i=0;i<s.length();i++){

            if(set.contains(s.charAt(i))){
                ans.setCharAt(i,'#');      // checking if the char of s is vowel or not
                list.add(s.charAt(i));    // adding vowels in list. 
            }else{
                ans.setCharAt(i,s.charAt(i));  // if character is consonant, put in strignbuilder as its place. 
            }
        }


        // sorting the list by ASCII        
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        
        // Putting back sorted vowels at position of vowel in stringbuilder. 
        int index=0;
        for(int i=0;i<s.length();i++){
            if(ans.charAt(i)=='#') ans.setCharAt(i,list.get(index++));
        }

        return ans.toString();
    }
}