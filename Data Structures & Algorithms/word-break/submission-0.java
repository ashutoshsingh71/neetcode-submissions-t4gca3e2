class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int maxLen = 0;
        boolean [] dp = new boolean[s.length()+1];

        for(String str : wordDict){
            maxLen = Math.max(maxLen,str.length());
            dict.add(str);
        }
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = Math.max(0,i-maxLen); j< i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
