class Solution {
    int [][] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int [nums.length][nums.length+1];
        for(int i = 0; i< nums.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(nums,0,-1);
    }

    private int dfs(int [] nums,int curr,int prev){
        if(curr == nums.length) return 0;

        if(memo[curr][prev+1] != -1) return memo[curr][prev+1];
        int len = dfs(nums,curr+1,prev);

        if(prev == -1 || nums[prev] < nums[curr]){
            len = Math.max(len,1 + dfs(nums,curr + 1,curr));
            memo[curr][prev+1] = len;
        }
        return len;
    }
}
