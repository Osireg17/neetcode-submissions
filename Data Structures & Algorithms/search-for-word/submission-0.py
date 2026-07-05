class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        visited = set()

        def dfs(r, c, visited, word, index):
            if index == len(word):
                return True
            if(r < 0 or r >= rows or c < 0 or c >= cols or (r, c) in visited or board[r][c] != word[index]):
                return False
            visited.add((r, c))
            directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
            for dr, dc in directions:
                if dfs(r + dr, c + dc, visited, word, index+1):
                    return True
            visited.remove((r, c))
            return False

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == word[0] and dfs(row, col, visited, word, 0):
                    return True
        return False