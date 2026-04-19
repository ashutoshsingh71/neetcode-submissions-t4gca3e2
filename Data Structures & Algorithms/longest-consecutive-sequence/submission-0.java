class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();

        for(int n : nums){
            s.add(n);
        }
        
        for(int num : nums){
            int streak = 0 , curr = num;
            while(s.contains(curr)){
                streak++;
                curr++;
            }
            res = Math.max(streak,res);
        }
        return res;
    }
}
