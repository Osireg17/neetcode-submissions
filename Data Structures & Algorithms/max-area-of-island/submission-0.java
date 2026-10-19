class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        // rows
        int rows = grid.length;
        // cols
        int cols = grid[0].length;
        // max area we've seen thus far
        int maxArea = 0;

        // two for loops on cols and rows
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int currentArea = 0;
                if (grid[r][c] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    // private method for the dfs
    private int dfs(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int currentArea = 1;
        for(int[] dir : directions){
            currentArea += dfs(grid, row + dir[0], col + dir[1]);
        }

        return currentArea;
    }
}
