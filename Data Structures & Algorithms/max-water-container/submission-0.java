class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1 ,res = 0;

        while(l < r){
            int curr = Math.min(heights[l],heights[r]) * (r-l);
            res = Math.max(curr,res);
            if(heights[l] <= heights[r]){
                l++;
            }else
                r--;
        }
        return res;
    }
}
