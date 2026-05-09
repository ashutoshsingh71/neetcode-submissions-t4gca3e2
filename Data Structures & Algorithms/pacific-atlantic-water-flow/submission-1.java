class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int Row = heights.length;
        int Col = heights[0].length;
        boolean [][] pacefic = new boolean [heights.length][heights[0].length];
        boolean [][] atlantic = new boolean [heights.length][heights[0].length];
        List<List<Integer>> answer = new ArrayList<>();
        for(int r = 0; r < heights.length;r++){
            dfs(r,0,pacefic,-1,-1,heights);
            dfs(r,heights[0].length-1,atlantic,-1,-1,heights);
        }
        for(int c = 0; c < heights[0].length;c++){
            dfs(0,c,pacefic,-1,-1,heights);
            dfs(heights.length-1,c,atlantic,-1,-1,heights);
        }
        for(int i = 0; i< Row;i++){
            for(int j = 0; j< Col;j++){
                if(atlantic[i][j] && pacefic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    answer.add(temp);
                }
            }
        }
        return answer;
    }

    private void dfs(int r, int j,boolean [][] visited,int or,int oj, int [][] heights){
        if(r < 0 || j < 0 || r >= heights.length || j >= heights[0].length || visited[r][j] || (or >= 0 && oj >= 0 && heights[r][j] < heights[or][oj])){
            return;
        }
        visited[r][j] = true;
        dfs(r+1,j,visited,r,j,heights);
        dfs(r-1,j,visited,r,j,heights);
        dfs(r,j+1,visited,r,j,heights);
        dfs(r,j-1,visited,r,j,heights);
    }
}
