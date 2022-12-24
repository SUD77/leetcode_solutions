class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
         List<Integer> res=new ArrayList<>();

        int[][] points=new int[student_id.length][2];

        //Will keep positive and negative words in these sets.
        Set<String> pos=new HashSet<>();
        Set<String> neg=new HashSet<>();

        for(String x:positive_feedback){
            pos.add(x);
        }

        for(String x:negative_feedback){
            neg.add(x);
        }

        
        int j=0;
        
        /*
        1. Iterate through the student id array
        2. Paralley split the report of that student in string array
        3. Check every word of that String array, if that word is in postive set
        add +3 and if it is negative set do -1.
        4. Store the student id and its total points, in point 2d array
        
        */
        for(int i=0;i< student_id.length;i++){

            String[] temp=null;

            temp=report[i].split(" ");

            int pt=0;
            for(String x:temp){
                if(pos.contains(x)){
                    pt+=3;
                }else if(neg.contains(x)){
                    pt-=1;
                }
            }

            points[j][0]= student_id[i];
            points[j][1]= pt;
            j++;

        }


        
        /* Sort the point 2d array by points of students and 
        if points are equal, sort by student id. 
        
        */

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1]==o2[1]){
                    return Integer.compare(o1[0],o2[0]);
                }else{
                    return Integer.compare(o2[1],o1[1]);
                }
            }
        });


        int tempK=0;

        
        // Choosing top k values
        while (tempK<k){
            res.add(points[tempK][0]);
            tempK++;
        }

        return res;
    }
}