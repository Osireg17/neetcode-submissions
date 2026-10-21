class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record RottenFruit(int row, int col) {}

    public int orangesRotting(int[][] grid) {
        Queue<RottenFruit> queue = new LinkedList<>();
        int timePassed = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new RottenFruit(row, col));
                }
            }
        }

        while (!queue.isEmpty()) {
            // we capture the size because the queue changes size while we're processing it.
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                RottenFruit current = queue.poll();
                int row = current.row();
                int col = current.col();

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newCol < 0 || newRow >= grid.length
                        || newCol >= grid[0].length || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;

                    queue.add(new RottenFruit(newRow, newCol));
                }
            }

            // will the queue is not empty just add time passed for the current level
            if(!queue.isEmpty()){
                timePassed ++;
            }
        }


        // We need to go through the matrix again to check if there is any unreached fruit
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }



        return timePassed;
    }
}
