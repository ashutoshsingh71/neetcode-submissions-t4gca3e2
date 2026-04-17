class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int [nums.length];
        //Brute-force
        /*for(int i = 0; i< nums.length;i++){
            int product = 1;
            for(int j = 0 ; j<nums.length;j++){
                if(i == j) continue;
                product *= nums[j];
            }
            res[i] = product;
        }*/
        //using devision
        /*int zerosCount = 0; int product = 1;
        for(int i : nums){
            if(i == 0){
                zerosCount++;
            }else{
                product *= i;
            }
        }
        if(zerosCount > 1){
            return new int[nums.length];
        }
        for(int i = 0; i< nums.length;i++){
            if(zerosCount > 0 ){
                res[i] = (nums[i] == 0) ? product : 0;
            }else{
                res[i] = product / nums[i];
            }
        }*/
        //Optimal approach
        int [] pre = new int [nums.length];
        int [] suff = new int [nums.length];

        pre[0] = 1;
        suff[suff.length - 1] = 1;
        for(int i = 1; i<nums.length;i++){
            pre[i] = pre[i-1]*nums[i-1];
        }
        for(int i = nums.length-2;i>=0;i--){
            suff[i] = suff[i+1]*nums[i+1];
        }
        for(int i = 0;i<nums.length;i++){
            res[i] = pre[i]*suff[i];
        }
        return res;
    }
}  
