class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums,0);
    }

    private boolean canJump(int [] nums,int i){
        if(i >= nums.length-1){
            return true;
        }
        
        int jumps = nums[i];
        for(int jump = 1;jump<=jumps;jump++){
            if(canJump(nums,i+jump)){
                return true;
            }
        }
        return false;
    }
}
