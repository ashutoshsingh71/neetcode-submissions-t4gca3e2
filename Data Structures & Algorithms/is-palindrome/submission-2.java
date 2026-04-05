class Solution {
    public boolean isPalindrome(String s) {
        boolean res = true;
        int i = 0;
        int j = s.length()-1;
        if(s.length() == 1){
            return res;
        }
        while(j >= i){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }  
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                res = false;
                break;
            }
            i++;
            j--;
        }
        return res;
    }
}
