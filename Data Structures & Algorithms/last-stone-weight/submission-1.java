class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            maxHeap.offer(n);
        }

        while(maxHeap.size() > 1){
            int weight1 = maxHeap.poll();
            int weight2 = maxHeap.poll();

            if(weight1 == weight2){
                continue;
            }else{
                int newWeight = Math.abs(weight1 - weight2);
                maxHeap.offer(newWeight);
            }
        }
        return maxHeap.peek() != null ? maxHeap.peek() : 0;
    }
}
