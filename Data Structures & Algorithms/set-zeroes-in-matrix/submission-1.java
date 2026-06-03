class Solution {
    public void setZeroes(int[][] matrix) {
        int Row = matrix.length;
        int Col = matrix[0].length;
        int [] row = new int [Row];
        Arrays.fill(row,Integer.MIN_VALUE);
        int [] col = new int [Col];
        Arrays.fill(col,Integer.MIN_VALUE);

        for(int i = 0; i< Row;i++){
            for(int j = 0; j< Col;j++){
                if(matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for(int i = 0; i<row.length;i++){
            if(row[i] == 0){
                int j = 0;
                while(j < Col){
                    matrix[i][j] = 0;
                    j++;
                }
            }
        }
        for(int j = 0; j<col.length;j++){
            if(col[j] == 0){
                int i = 0;
                while(i < Row){
                    matrix[i][j] = 0;
                    i++;
                }
            }
        }
    }
}
