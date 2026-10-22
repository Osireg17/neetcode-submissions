class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record Cell(int row, int col) {}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Stack<Cell> pacificStack = new Stack<>();
        Stack<Cell> atlanticStack = new Stack<>();
        Set<Cell> pacificVisited = new HashSet<>();
        Set<Cell> atlanticVisited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // add to each specific and atlantic stack and visited set
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                if (pacificBoundary(i, j)) {
                    pacificStack.push(cell);
                    pacificVisited.add(cell);
                }
                if (atlanticBoundary(i, j, heights)) {
                    atlanticStack.push(cell);
                    atlanticVisited.add(cell);
                }
            }
        }

        // pacific traversal
        while (!pacificStack.isEmpty()) {
            Cell current = pacificStack.pop();
            dfs(heights, current.row(), current.col(), pacificVisited);
        }

        // atlantic traversal
        while (!atlanticStack.isEmpty()) {
            Cell current = atlanticStack.pop();
            dfs(heights, current.row(), current.col(), atlanticVisited);
        }

        // comparision
        for (Cell cell : pacificVisited) {
            if (atlanticVisited.contains(cell)) {
                result.add(List.of(cell.row(), cell.col()));
            }
        }

        return result;
    }

    private boolean pacificBoundary(int row, int col) {
        if (row == 0 || col == 0) {
            return true;
        }
        return false;
    }

    private boolean atlanticBoundary(int row, int col, int[][] heights) {
        if (row == heights.length - 1 || col == heights[0].length - 1) {
            return true;
        }
        return false;
    }

    // iterative dfs method
    private void dfs(int[][] heights, int row, int col, Set<Cell> visited) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(row, col));

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            visited.add(current);

            for (int[] direction : directions) {
                int newRow = current.row() + direction[0];
                int newCol = current.col() + direction[1];

                if (newRow >= 0 && newRow < heights.length && newCol >= 0
                    && newCol < heights[0].length) {
                    Cell neighbor = new Cell(newRow, newCol);
                    if (!visited.contains(neighbor)
                        && heights[newRow][newCol] >= heights[current.row()][current.col()]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}