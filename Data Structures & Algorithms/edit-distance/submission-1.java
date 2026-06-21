class Solution {
    int [][] dp;
    public int minDistance(String word1, String word2) {
        int startFirst = word1.length()-1;
        int startSecond = word2.length()-1;
        dp = new int [word1.length()][word2.length()];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
        return minCost(word1,startFirst,word2,startSecond);
    }

    private int minCost(String word1, int startOne, String word2, int startTwo){
        if(startOne < 0) return startTwo+1;
        if(startTwo < 0) return startOne+1;

        if(dp[startOne][startTwo] != -1) return dp[startOne][startTwo];
        if(word1.charAt(startOne) == word2.charAt(startTwo)){
           return minCost(word1,startOne-1,word2,startTwo-1);
        }
        int insert = minCost(word1,startOne,word2,startTwo-1);
        int delete = minCost(word1,startOne-1,word2,startTwo);
        int replace = minCost(word1,startOne-1,word2,startTwo-1);
        dp[startOne][startTwo] = 1 + Math.min(insert,Math.min(delete,replace));
        return dp[startOne][startTwo];
    }
}
