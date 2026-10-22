class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record Cell(int row, int col) {}

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Set<Cell> visited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O' && boundaryConditions(row, col, board)) {
                    dfs(board, row, col, visited);
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(!visited.contains(new Cell(row, col)) && board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, Set<Cell> visited) {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(row, col));

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            visited.add(current);

            for (int[] direction : directions) {
                int newRow = current.row() + direction[0];
                int newCol = current.col() + direction[1];

                if (newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length
                    || board[newRow][newCol] == 'X') {
                    continue;
                }

                Cell neighbor = new Cell(newRow, newCol);
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    private boolean boundaryConditions(int row, int col, char[][] board) {
        if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1) {
            return true;
        }
        return false;
    }
}
