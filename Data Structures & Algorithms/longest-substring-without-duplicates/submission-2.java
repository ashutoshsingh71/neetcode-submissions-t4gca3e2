class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        //brute force approach o(n*m)
        /*for(int i = 0; i<s.length();i++){
            Set<Character> charSet = new HashSet<>();

            for(int j = i;j<s.length();j++){
                if(charSet.contains(s.charAt(j))){
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res,charSet.size());
        }*/
        //optimal approach
        int i= 0;
        Set<Character> charSet = new HashSet<>();
        for(int j =0;j < s.length();j++){
            while(charSet.contains(s.charAt(j))){
                charSet.remove(s.charAt(i));
                i += 1;
            }
            charSet.add(s.charAt(j));
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
