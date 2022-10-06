class Solution {
    //DFS without visited array
    //TC - O(V*V) - grid sz
    //SC - O(V) - stack space
    public int numIslands(char[][] grid) {
        
        // - | and not \ / way
        
      //     |
      // |   -   |
      //     |
              int res = 0;
      for(int i=0; i<grid.length; ++i) {
          for(int j=0; j<grid[0].length; ++j) {
              if(grid[i][j] == '1') {
                  res++;
                  doDfs(grid, i, j);
              }
          }
      }
        
        return res;
              
    }
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};
    private void doDfs(char[][] grid, int row, int col) {
        
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!='1')
            return;
        
        grid[row][col] = '0';
        
        for(int i=0; i<4; ++i)
            doDfs(grid, row+dx[i], col+dy[i]);
        
        return;
    }
}
