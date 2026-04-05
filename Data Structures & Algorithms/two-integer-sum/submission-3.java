class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        //Brute Force approach
        /*
        for(int i = 0; i<= nums.length - 1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;*/
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i< nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) > i){
                res[0] = i;
                res[1] = map.get(diff);
                return res;
            }
        }
        return res;
    }
}
