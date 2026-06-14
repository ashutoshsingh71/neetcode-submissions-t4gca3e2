class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int memo [] = new int [cost.length];
        return Math.min(dfs(cost,0,memo),dfs(cost,1,memo));
    }

    private int dfs(int [] cost,int i,int [] memo){
        if(i >= cost.length){
            return 0;
        }
        if(memo[i] > 0){
            return memo[i];
        }else{
            memo[i] = cost[i] + Math.min(dfs(cost,i+1,memo),dfs(cost,i+2,memo));
            return memo[i];
        }
    }
}
