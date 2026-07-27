
class Twitter {
    private static int timestamp = 0;
    private class Tweet{
        int id;
        int time;
        Tweet(int id){
            this.id = id;
            this.time = timestamp++;
        }
    }
    private Map<Integer,Set<Integer>> followMap;
    private Map<Integer,List<Tweet>> tweetmap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetmap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId,new ArrayList<>());
        tweetmap.get(userId).add(new Tweet(tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int []> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        Set<Integer> users = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
        users.add(userId);

        for(int u : users){
            List<Tweet> tweets = tweetmap.get(u);
            if(tweets != null && !tweets.isEmpty()){
                int lastIdx = tweets.size()-1;
                Tweet t = tweets.get(lastIdx);
                maxHeap.add(new int [] {t.time,t.id,u,lastIdx});
            }
        }

        while(!maxHeap.isEmpty() && res.size()< 10){
            int [] top = maxHeap.poll();
            res.add(top[1]);

            int u = top[2];
            int nextIdx = top[3]-1;
            if(nextIdx >= 0){
                Tweet nextTweet = tweetmap.get(u).get(nextIdx);
                maxHeap.add(new int [] {nextTweet.time,nextTweet.id,u,nextIdx});
            }
        }
        return res;
    } 
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
