class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record Cell(int row, int col) {}

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Cell(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Cell current = queue.poll();
                int row = current.row();
                int col = current.col();

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newCol < 0 || newRow >= grid.length
                        || newCol >= grid[0].length || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;

                    queue.add(new Cell(newRow, newCol));
                }
            }

            if (!queue.isEmpty()) {
                count++;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }
}