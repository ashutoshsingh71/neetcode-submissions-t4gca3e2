class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums,0,0,target);
    }

    private int ways(int [] nums, int index,int currentSum, int target){
        if(index == nums.length){
            return currentSum == target ? 1 : 0;
        }
        return ways(nums,index+1,currentSum + nums[index],target) + 
                ways(nums,index+1,currentSum - nums[index],target);
    }
}
