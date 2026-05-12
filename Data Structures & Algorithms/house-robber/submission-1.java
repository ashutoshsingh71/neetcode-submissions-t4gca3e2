class Solution {
    public int rob(int[] nums) {
        int i = 0;
        int [] memo = new int [nums.length];
        return dfs(nums,0,memo);
    }

    private int dfs(int [] nums,int i,int [] memo){
        if(i >= nums.length) return 0;
        if(memo[i] != 0){
            return memo[i];
        }
        memo[i] = Math.max(nums[i] + dfs(nums,i+2,memo),dfs(nums,i+1,memo));
        return memo[i];
    }
}
