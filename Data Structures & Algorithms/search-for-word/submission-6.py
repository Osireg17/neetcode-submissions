class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        res = []
        coordinates = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        row, col = len(board), len(board[0])


        def dfs(r, c, i):
            if i == len(word):
                return True
            if r < 0 or r >= row or c < 0 or c >= col or board[r][c] != word[i]:
                return False

            board[r][c] = '#'
            for dr, dc in coordinates:
                if dfs(r + dr, c + dc, i + 1):
                    return True
            board[r][c] = word[i]
            return False


        for r in range(row):
            for c in range(col):
                if dfs(r, c, 0):
                    return True
        return False








