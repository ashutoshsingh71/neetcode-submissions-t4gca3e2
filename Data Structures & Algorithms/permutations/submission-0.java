class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(nums,current,res,new boolean[nums.length]);
        return res;
    }

    private void dfs(int [] nums, List<Integer> current, List<List<Integer>> res,boolean [] used){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i< nums.length;i++){
            if(used[i]) continue;
            
            used[i] = true;
            current.add(nums[i]);
            dfs(nums,current,res,used);

            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
