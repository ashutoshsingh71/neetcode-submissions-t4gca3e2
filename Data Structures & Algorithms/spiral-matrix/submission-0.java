class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int r = matrix.length;
        int c = matrix[0].length;

        int top = 0, bottom = r;
        int left = 0,right = c;

        while(top < bottom && left < right){
            for(int i = left;i<right;i++){
                res.add(matrix[top][i]);
            }
            top += 1;
            for(int i = top; i < bottom;i++){
                res.add(matrix[i][right-1]);
            }
            right -= 1;

            if(!(top < bottom && left < right)){
                break;
            }
            for(int i = right-1;i >= left;i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom -= 1;
            for(int i = bottom-1; i>= top;i--){
                res.add(matrix[i][left]);
            }
            left += 1;
        }
        return res;
    }
}
