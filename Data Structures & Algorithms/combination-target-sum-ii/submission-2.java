class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,candidates,target,subset,res);
        return res;
    }

    private void dfs(int i, int [] candidates,int target,List<Integer> subset,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }
        subset.add(candidates[i]);
        dfs(i+1,candidates,target - candidates[i],subset,res);
        
        subset.remove(subset.size()-1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(i+1,candidates,target,subset,res);
            
        
    }
}
