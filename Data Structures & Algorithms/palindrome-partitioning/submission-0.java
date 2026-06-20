class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        int n = s.length();
        boolean [][] palindrome = new boolean[n][n];

        for(int i = 1; i<=n; i++){
            for(int j = 0;j <= n-i; j++){
                palindrome[j][j+i-1] = (s.charAt(j) == s.charAt(i+j-1) && 
                    (j+1 > (j+i-2) ||
                    palindrome[j+1][j+i-2]));
            }
        }
        List<String> part = new ArrayList<>();
        backtrack(0,s,palindrome,part,res);
        return res;
    }

    private void backtrack(int i,String s, boolean [][] palindrome,List<String> part,List<List<String>> res){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        
        for(int j = i;j<s.length();j++){
            if(palindrome[i][j]){
                part.add(s.substring(i,j+1));
                backtrack(j+1,s,palindrome,part,res);
                part.remove(part.size()-1);
            }
        }
    }
}
