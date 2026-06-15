class Solution {
    Queue<int []> queue = new LinkedList<>();
    public void islandsAndTreasure(int[][] grid) {
        int Row = grid.length;
        int Col = grid[0].length;
        Set<int []> visited = new HashSet<>();

        for(int i = 0; i< Row;i++){
            for(int j = 0; j< Col;j++){
                if(grid[i][j] == 0){
                    int [] pos = new int[] {i,j};
                    queue.offer(pos);
                    visited.add(pos);
                }
            }
        }
        if(queue.isEmpty()) return;
        int dist = 0;
        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        while(!queue.isEmpty()){
           int [] cord = queue.poll();
           int row = cord[0];
           int col = cord[1];
           /*addRoom(cord[0] + 1,cord[1],grid,row,col,visited);
           addRoom(cord[0] - 1,cord[1],grid,row,col,visited);
           addRoom(cord[0],cord[1] + 1,grid,row,col,visited);
           addRoom(cord[0],cord[0] - 1,grid,row,col,visited);
           grid[cord[0]][cord[1]] = grid[cord[0]][cord[1]] +1;*/
           for(int [] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            if(r >= Row || c >= Col || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                continue;
            }
            queue.offer(new int[]{r,c});
            grid[r][c] = grid[row][col]+1;
           }
        }
    }

    private void addRoom(int r, int c, int[][] grid,int row,int col,Set<int []> visited){
        if(r >= row || c >= col || r <0 || c < 0 || grid[r][c] != Integer.MAX_VALUE || visited.contains(new int[]{r,c})){
            return;
        }
        int [] pos = new int[]{r,c};
        queue.offer(pos);
        visited.add(pos);
    }
}
