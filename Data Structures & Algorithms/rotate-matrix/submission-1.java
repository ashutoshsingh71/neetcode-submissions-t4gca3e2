class Solution {
    public void rotate(int[][] matrix) {
        /*int l = 0;
        int r = matrix.length-1;

        while(l < r){
            for(int i = 0; i< r-l;i++){
                int top = l;
                int bottom = r;

                int topLeft = matrix[top][l+i];
                matrix[top][l+i] = matrix[bottom-i][l];
                matrix[bottom-i][l] = matrix[bottom][r-i];
                matrix[bottom][r-i] = matrix[top+i][r];
                matrix[top+i][r] = topLeft;

            }
            l++;
            r--;
            
        }*/
        reverse(matrix);
        transpose(matrix);
    }
    private void reverse(int [][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0 ;i< r/2 ;i++){
            int [] temp = matrix[i];
            matrix[i] = matrix[r-1-i];
            matrix[r-1-i] = temp;
        }
    }

    private void transpose(int [][] matrix){
        int n = matrix.length;
        for(int i =0 ; i< matrix.length;i++){
            for(int j = i; j< matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
