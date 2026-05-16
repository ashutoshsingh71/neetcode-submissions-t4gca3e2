class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
            int minCoins = dfs(coins,amount);
            return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    private int dfs(int [] coins,int amount){
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        if(memo.containsKey(amount)) return memo.get(amount);
        for(int c : coins){
            if(amount - c >= 0){
                int result = dfs(coins,amount - c);
                if(result != Integer.MAX_VALUE){
                    res= Math.min(res,1 + result);
                }
            }
        }
        memo.put(amount,res);
        return res;
    }
}
