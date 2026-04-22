class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        for(int i = 0; i< s.length();i++){
            Map<Character,Integer> charSet = new HashMap<>();
            int maxF= 0;
            for(int j = i;j<s.length();j++){
                charSet.put(s.charAt(j),charSet.getOrDefault(s.charAt(j),0) + 1);
                maxF = Math.max(maxF,charSet.get(s.charAt(j)));
                if((j-i+1) - maxF <= k){
                    res = Math.max(res,(j-i+1));
                }
            }
        }
        return res;
    }
}
