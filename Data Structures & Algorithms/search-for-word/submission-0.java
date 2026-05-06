class Solution {
    private int Rows,Cols;
    private boolean [][] visited;
    
    public boolean exist(char[][] board, String word) {
        Rows = board.length;
        Cols = board[0].length;
        visited = new boolean [Rows][Cols];
        for(int r = 0; r < Rows;r++){
            for(int c = 0; c < Cols;c++){
                if(backtrack(board,word,r,c,0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char [][] board,String word,int r,int c, int i){
        if(i == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= Rows || c >= Cols || board[r][c] != word.charAt(i) || visited[r][c]){
            return false;
        } 
        visited[r][c] = true;
        boolean res = backtrack(board,word,r+1,c,i+1) || 
                        backtrack(board,word,r-1,c,i+1) || 
                        backtrack(board,word,r,c+1,i+1) || 
                        backtrack(board,word,r,c-1,i+1);
        visited[r][c] = false;
        return res;
    }
}
