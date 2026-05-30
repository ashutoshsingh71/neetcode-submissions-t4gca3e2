class Solution {
    public int trap(int[] height) {
        /*int [] lMax = new int [height.length];
        int [] rMax = new int [height.length];

        lMax[0] = height[0];
        rMax[height.length-1] = height[height.length-1];

        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        
        for(int i = 1; i< height.length;i++){
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        for(int i = height.length-2; i >= 0;i--){
            rMax[i] = Math.max(rMax[i+1],height[i]);
        }
        int res = 0 ;
        for(int i = 0; i<height.length;i++){
            res += Math.min(lMax[i],rMax[i]) - height[i];
        }
        return res;*/
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int l = 0;
        int r = height.length-1;
        int res = 0;
        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax,height[l]);
                res += leftMax - height[l];
            }else{
                r--;
                rightMax = Math.max(rightMax,height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
