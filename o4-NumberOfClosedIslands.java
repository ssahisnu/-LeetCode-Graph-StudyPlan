class Solution {
    //DFS 
    //TC - O(V*V)
    //SC - O(V*V) - all 0's 
    public int closedIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int compCtr = 0;
        int ctr = 2;
        boolean[] isEdge = new boolean[]{false};
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(grid[i][j]==0){
                    isEdge[0] = false;
                    markConnectedCom(grid,i,j,ctr++,isEdge);
                    compCtr = (isEdge[0]? compCtr:compCtr+1);
                }
            }
        }
        
       return compCtr;
    }
    
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    private void markConnectedCom(int[][] grid, int row, int col, int n, boolean[] isEdge) {
        
        if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!=0)
            return;
        
        grid[row][col] = n;
        if(row==0||col==0||row==grid.length-1||col==grid[0].length-1) isEdge[0]=true;
        
        for(int i=0; i<4; ++i){
            markConnectedCom(grid, row+dx[i], col+dy[i], n, isEdge);
        }
    }
}
