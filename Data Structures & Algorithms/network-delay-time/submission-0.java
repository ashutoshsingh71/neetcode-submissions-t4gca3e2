class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adjList = new ArrayList<>();
        int res = Integer.MIN_VALUE;
        for(int i = 0; i< n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] time : times){
            int source = time[0] - 1;
            int dest = time[1] - 1;
            int weight = time[2];
            adjList.get(source).add(new int [] {weight,dest});
        }

        int [] dist = new int [n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        pq.offer(new int[] {0,k-1});
        while(!pq.isEmpty()){
            int [] node = pq.poll();
            
            int w = node[0];
            int d = node[1];
            if(w > dist[d]) continue;
            List<int []> neighbours = adjList.get(d);
            for(int j = 0; j<neighbours.size();j++){
                int [] edge = neighbours.get(j);
                int wei = edge[0];
                int nei = edge[1];
                if(w + wei < dist[nei]){
                    dist[nei] = w + wei;
                    pq.offer(new int [] {w + wei ,nei});
                }
            }
        }
        
        for(int t : dist){
            res = Math.max(res,t);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
