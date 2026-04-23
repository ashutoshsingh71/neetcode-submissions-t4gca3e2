class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int pivot = findPivot(nums);
        l = 0;
        r = nums.length-1;

        if(target >= nums[pivot] && target <= nums[r]){
            l = pivot;
        }else{
            r = pivot-1;
        }
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }

    public int findPivot(int [] nums){
        int l = 0 ;
        int r = nums.length-1;
        if(nums[l] < nums[r]) return 0;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else
                r = mid;
        }
        return l;
    }
}
