class Solution {
    /*public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i< n;i++){
            int height = heights[i];

            int rightMost = i+1;
            while(rightMost < n && heights[rightMost] >= height){
                rightMost++;
            }

            int leftMost = i;
            while(leftMost >=0 && heights[leftMost] >= height){
                leftMost--;
            }

            rightMost--;
            leftMost++;
            maxArea = Math.max(maxArea,height * (rightMost-leftMost+1));
        }
        return maxArea;
    }*/

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i< heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int [] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea,height * (i - index));
                start = index;
            }
            stack.push(new int[]{start,heights[i]});
        }

        for(int [] pair : stack){
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea,height * (heights.length-index));
        }
        return maxArea;
    }
}
