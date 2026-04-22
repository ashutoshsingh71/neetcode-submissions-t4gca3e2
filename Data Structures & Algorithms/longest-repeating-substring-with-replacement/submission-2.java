class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        //O(n2)
        /*for(int i = 0; i< s.length();i++){
            Map<Character,Integer> charSet = new HashMap<>();
            int maxF= 0;
            for(int j = i;j<s.length();j++){
                charSet.put(s.charAt(j),charSet.getOrDefault(s.charAt(j),0) + 1);
                maxF = Math.max(maxF,charSet.get(s.charAt(j)));
                if((j-i+1) - maxF <= k){
                    res = Math.max(res,(j-i+1));
                }
            }
        }*/
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        for(char c : set){
            int count = 0;
            int l = 0;
            for(int r = 0; r < s.length();r++){
                if(s.charAt(r) == c){
                    count++;
                }
                while((r-l+1) - count > k){
                    if(s.charAt(l) == c){
                        count--;
                    }
                    l++;
                }
                res = Math.max(res,(r-l+1));
            }
        }
        return res;
    }
}
