class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        backtrack(nums,new ArrayList<Integer>(),0,0,target);
        return res;
    }

    private void backtrack(int [] nums,List<Integer> curr,int i,int total,int target){
        if(total == target){
            res.add(new ArrayList(curr));
            return;
        }
        if(i >= nums.length || total > target){
            return;
        }
        curr.add(nums[i]);
        backtrack(nums,curr,i,total+nums[i],target);
        curr.remove(curr.size()-1);
        backtrack(nums,curr,i+1,total,target);
    }
}
