class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if(sum % 2 != 0) return false;
        int target = sum/2;
        return backtrack(0,nums,target);
    }

    private boolean backtrack(int i,int [] nums,int target){
        if(target == 0){
            return true;
        }
        if(i == nums.length-1 && target == nums[i]){
            return true;
        }
        if(i >= nums.length) return false;
        return backtrack(i+1,nums,target-nums[i]) || backtrack(i+1,nums,target);
    }
}
