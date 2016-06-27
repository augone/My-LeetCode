public class MedianFinder {

    PriorityQueue<Integer> upper = new PriorityQueue<>();
    PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(upper.size() == 0||upper.peek() < num)
        {
            upper.add(num);
        }
        else lower.add(num);
        
            
    }

    // Returns the median of current data stream
    public double findMedian() {
        balance(upper,lower);
        if(upper.size() > lower.size())
        {
            return (double)upper.peek();
        }
        else if(upper.size() < lower.size())
        {
            return (double)lower.peek();
        }
        else if(upper.size() == 0)
            return 0;
        else return (((double)(lower.peek()+upper.peek()))/(2));
        
    }
    public void balance(PriorityQueue<Integer> upper,PriorityQueue<Integer> lower)
    {
        while(upper.size() > lower.size()+1)
        {
            lower.add(upper.remove());
        }
        while(lower.size() > upper.size()+1)
        {
            upper.add(lower.remove());
        }
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();