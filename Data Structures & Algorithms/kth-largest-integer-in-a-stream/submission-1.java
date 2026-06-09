class KthLargest {
    Queue<Integer> minHeap;
    int size;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.offer(n);
            if(minHeap.size() > size){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > size){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
