class Solution {
    int [] memo;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = nums.length-1;

        for(int i = n-1;i>=0;i--){
            if(i+nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
       /* memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return canJump(nums,0);*/
    }

    private boolean canJump(int [] nums,int i){
        if(i >= nums.length-1){
            return true;
        }
        if(memo[i] != -1){
            return (memo[i] == 1) ? true : false;
        }
        int jumps = nums[i];
        for(int jump = 1;jump<=jumps;jump++){
            if(canJump(nums,i+jump)){
                memo[i+jump] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}
