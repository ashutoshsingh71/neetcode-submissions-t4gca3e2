class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        //brute force O (n2)
        /*Set<Integer> s = new HashSet<>();

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
        }*/
        //Optimal approach O(nlong n)
        /*if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int curr = nums[0],streak = 0,i = 0;
        while(i < nums.length){
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }
            while(i < nums.length && nums[i] == curr){
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res,streak);
        }*/
        //Best Approach O(n)
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for(int n : set){
            if(!set.contains(n-1)){
                int length = 1;
                while(set.contains(n + length)){
                    length++;
                }
                res = Math.max(res,length);
            }
            
        }
        return res;
    }
}
