/*
Time Complexity : O(n*m)    where n and m are the dimensions of the input grid.
Space Complexity : O(n*m)
*/

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }   
}       

class Solution {
    // BFS function to explore and mark connected land cells.
    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            // Traverse in the neighbors and mark them if it's a land.
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    // DFS function to explore and mark connected land cells.
    private void dfs(int ro, int co, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        vis[ro][co] = 1;
        
        // Traverse in the neighbors and mark them if it's a land.
        for (int delrow = -1; delrow <= 1; delrow++) {
            for (int delcol = -1; delcol <= 1; delcol++) {
                int nrow = ro + delrow;
                int ncol = co + delcol;
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    dfs(nrow, ncol, vis, grid);
                }
            }
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        
        // Loop through each cell in the grid.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;
                   
                    dfs(row, col, vis, grid);
                    // bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}
