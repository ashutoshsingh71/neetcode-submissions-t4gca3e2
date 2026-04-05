class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        boolean res = true;
        int [] arr = new int[26];

        for(int i = 0; i< s.length();i++){
            int pos = s.charAt(i) - 'a';
            arr[pos] = arr[pos] + 1;
        }

        for(int i = 0; i< t.length();i++){
            int pos = t.charAt(i) - 'a';
            arr[pos] = arr[pos] - 1;
        }

        for(int i = 0; i< 26 ;i++){
            if(arr[i] != 0){
                res = false;
                break;
            }
        } 
        return res;
    }
}
