class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean [][] visited = new boolean[ROW][COL];
        int count = 0;
        for(int r = 0;r < ROW; r++){
            for(int c = 0; c < COL ; c++){
                if(grid[r][c] == '1'){
                    dfs(grid,r,c,ROW,COL,visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char [][] grid,int r,int c,int ROW,int COL, boolean [][] visited){
        if(r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int [] dir : directions){
                dfs(grid,r+dir[0],c+dir[1],ROW,COL,visited);
        }
    }
}
