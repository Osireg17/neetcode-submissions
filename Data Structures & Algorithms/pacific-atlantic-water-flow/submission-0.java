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

            for (int[] direction : directions) {
                int newRow = current.row() + direction[0];
                int newCol = current.col() + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    Cell neighbour = new Cell(newRow, newCol);
                    if (!pacificVisited.contains(neighbour)
                        && heights[newRow][newCol] >= heights[current.row()][current.col()]) {
                        pacificStack.push(neighbour);
                        pacificVisited.add(neighbour);
                    }
                }
            }
        }

        // atlantic traversal
        while (!atlanticStack.isEmpty()) {
            Cell current = atlanticStack.pop();

            for (int[] direction : directions) {
                int newRow = current.row() + direction[0];
                int newCol = current.col() + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    Cell neighbour = new Cell(newRow, newCol);
                    if (!atlanticVisited.contains(neighbour)
                        && heights[newRow][newCol] >= heights[current.row()][current.col()]) {
                        atlanticStack.push(neighbour);
                        atlanticVisited.add(neighbour);
                    }
                }
            }
        }

        // comparision
        for(Cell cell: pacificVisited){
            if(atlanticVisited.contains(cell)){
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
}
