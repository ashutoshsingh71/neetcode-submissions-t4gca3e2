class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int[nums1.length + nums2.length];
        double res = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                k++;
                i++;
            }else if(nums1[i] > nums2[j]){
                nums[k] = nums2[j];
                k++;
                j++;
            }else{
                nums[k++] = nums1[i];
                nums[k] = nums2[j];
                k++;
                i++;
                j++;
            }
        }

        while(i < nums1.length){
            nums[k] = nums1[i];
            k++;
            i++;
        }
        while(j < nums2.length){
            nums[k] = nums2[j];
            k++;
            j++;
        }
        for(int p : nums){
            System.out.print(p + " ");
        }
        if(nums.length % 2 == 0){
            int mid = nums.length / 2 ;
            res = (double)(nums[mid-1] + nums[mid]) / 2;
        }else{
            int mid = nums.length / 2 ;
            res = nums[mid];
        }
        return res;
    }
}
