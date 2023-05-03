class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set2=new HashSet<>();

        List<Integer> list1=new ArrayList<>();

        Set<Integer> list1Contains=new HashSet<>();

        

        for(Integer i:nums2)

        {

            set2.add(i);

        }

        

        for(Integer i:nums1)

        {

            if(!list1Contains.contains(i)&&!set2.contains(i))

            {

                list1.add(i);

                list1Contains.add(i);

            }

        }

        

        

        Set<Integer> set1=new HashSet<>();

        List<Integer> list2=new ArrayList<>();

        Set<Integer> list2Contains=new HashSet<>();

        

        for(Integer i:nums1)

        {

            set1.add(i);

        }

        

        for(Integer i:nums2)

        {

            if(!list2Contains.contains(i)&&!set1.contains(i))

            {

                list2.add(i);

                list2Contains.add(i);

            }

        }

        

        List<List<Integer>> ret=new ArrayList();

        ret.add(list1);

        ret.add(list2);

        return ret;
    }
}