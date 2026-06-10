class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;

        for(char c : tasks){
            freq.put(c,freq.getOrDefault(c,0) + 1);
        }

        for(int count : freq.values()){
            maxHeap.offer(count);
        }
        Queue<int []> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = queue.peek()[1];
            }else{
                int cnt = maxHeap.poll()-1;
                if(cnt > 0){
                    queue.add(new int []{cnt,time+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
