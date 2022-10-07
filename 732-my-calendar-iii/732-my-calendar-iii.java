class MyCalendarThree {

    private TreeMap<Integer,Integer> timeline=new TreeMap<>();
    
    public MyCalendarThree() {
        
    }
    
    public int book(int start, int end) {
        
        timeline.put(start,timeline.getOrDefault(start,0)+1);
        timeline.put(end,timeline.getOrDefault(end,0)-1);
        
        int ongoing=0, count=0;
        
        for(int v: timeline.values()){
            count=Math.max(count,ongoing+=v);
        }
        
        return count;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */