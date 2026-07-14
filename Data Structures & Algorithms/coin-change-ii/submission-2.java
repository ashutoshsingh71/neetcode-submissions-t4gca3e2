class Solution {
    public int change(int amount, int[] coins) {
        int res = Integer.MAX_VALUE;
        int [][] memo = new int [coins.length][amount+1];
        for(int [] row : memo){
            Arrays.fill(row,-1);
        }
        res = Math.min(res,coinChange(coins,amount,0,memo));
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int coinChange(int [] coins,int amount, int index,int [][] memo){
       if(amount < 0 || index >= coins.length) return 0;
        if(amount == 0) return 1;
        if(memo[index][amount] != -1) return memo[index][amount];
        int includeCoin = coinChange(coins,amount - coins[index],index,memo);
        int excludeCoin = coinChange(coins,amount,index+1,memo);
        memo[index][amount] = includeCoin + excludeCoin;
        return memo[index][amount];
    }
}
