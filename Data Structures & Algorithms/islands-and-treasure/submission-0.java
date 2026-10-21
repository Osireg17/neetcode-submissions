class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record Cell(int row, int col) {}

    public void islandsAndTreasure(int[][] grid) {
        // traverse the grid adding all treasure chest's to a grid

        Queue<Cell> queue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.add(new Cell(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row();
            int col = current.col();

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length
                    || grid[newRow][newCol] == -1) {
                    continue;
                }

                //checking if the new row we are at is currently a land cell
                if (grid[newRow][newCol] == Integer.MAX_VALUE) {
                    // we are moving outwards from the chest so the distance is one more
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.add(new Cell(newRow, newCol));
                }
            }
        }
    }
}
