// https://www.youtube.com/watch?v=KtJlTfHtMhc&t=1319s

class MedianFinder {

    PriorityQueue<Integer> minHeap=null;
    PriorityQueue<Integer> maxHeap=null;
    
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */