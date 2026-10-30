class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(1, 0), (0, 1), (0, -1), (-1, 0)]
        rows, cols = len(board), len(board[0])
        index = 0

        def dfs(row, col):
            nonlocal index
            if index == len(word):
                return True
            
            if (
                row < 0
                or col < 0
                or row >= len(board)
                or col >= len(board[0])
                or board[row][col] != word[index]
            ):
                return False
            
            temp = board[row][col]
            board[row][col] = "#"
            index += 1
            
            for dx, dy in directions:
                if dfs(row + dx, col + dy):
                    return True
            board[row][col] = temp
            index -= 1

        

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == word[0]:
                    if dfs(row, col):
                        return True
        return False
