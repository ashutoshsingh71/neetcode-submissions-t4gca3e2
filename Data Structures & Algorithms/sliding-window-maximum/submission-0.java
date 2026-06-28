class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int l =0,r =0;
        while(r < nums.length){
            while(r-l+1 > k){
                l++;
            }
            if(r - l + 1 == k){
                res.add(findMax(nums,l,r));
            }
            r++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int findMax(int [] nums,int l,int r){
        int max = Integer.MIN_VALUE;
        while(l <= r){
            if(nums[l] > max){
                max = nums[l];
            }
            l++;
        }
        return max;
    }
}
