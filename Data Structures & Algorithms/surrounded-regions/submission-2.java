class Solution {
    public void solve(char[][] board) {
        List<int []> list = new ArrayList();
        int Row = board.length;
        int Col = board[0].length;
        
        for(int i = 0; i< Row;i++){
            for(int j = 0;j<Col;j++){
                if(i == 0 || i == Row-1 || j == 0 || j == Col-1){
                    dfs(i,j,board,Row,Col);
                }
            }
        }

        for(int i = 0; i< Row;i++){
            for(int j = 0; j< Col;j++){
                if(board[i][j] != 'T'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i< Row;i++){
            for(int j = 0; j< Col;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char [][] board,int Row, int Col){
        if(r < 0 || c < 0 || r >= Row || c >= Col || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        dfs(r-1,c,board,Row,Col);
        dfs(r+1,c,board,Row,Col);
        dfs(r,c+1,board,Row,Col);
        dfs(r,c-1,board,Row,Col);
    }
}
