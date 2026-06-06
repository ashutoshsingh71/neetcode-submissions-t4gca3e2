class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int first =0;
        int last = matrix.length-1;
        int col = matrix[0].length-1;
        int rowToSearch = 0;
        while(first <= last){
            int mid = first + (last-first/2);
            if(target >= matrix[mid][0] && target <= matrix[mid][col]){
                rowToSearch = mid;
                break;
            }else if(target < matrix[mid][0]){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
        
        int l = 0;
        int r = col;

        while(l <= r){
            int mid = l + (r-l/2);
            if(matrix[rowToSearch][mid] == target){
                return true;
            }else if(matrix[rowToSearch][mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}
