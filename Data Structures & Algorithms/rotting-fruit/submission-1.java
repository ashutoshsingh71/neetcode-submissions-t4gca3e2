class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        int Row = grid.length;
        int Col = grid[0].length;
        int fresh = 0;
        //boolean [][] visited = new boolean[Row][Col];

        for(int i = 0; i< Row;i++){
            for(int j = 0; j < Col;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                    //visited[i][j] = true;
                }
            }
        }
        int time = 0;
        int [][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        while(fresh > 0 && !queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i< len;i++){
                int [] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                for(int [] dir : dirs){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r < Row && c < Col && r >= 0 && c >= 0 && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
