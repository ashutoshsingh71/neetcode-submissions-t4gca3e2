class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> freqMap = new HashMap<>();
        Map<Character,Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int l = 0,r = 0;
        for(char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        int required = freqMap.size();
        int formed = 0;

        while(r < s.length()){
            char c = s.charAt(r);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);

            if(freqMap.containsKey(c) && freqMap.get(c).intValue() == windowMap.get(c).intValue()){
                formed++;
            }

            while(l <= r && formed == required){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    left = l;
                }
                char leftChar = s.charAt(l);
                windowMap.put(leftChar,windowMap.get(leftChar)-1);

                if(freqMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < freqMap.get(leftChar).intValue()){
                    formed--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(left,left+minLen);
    }
}
