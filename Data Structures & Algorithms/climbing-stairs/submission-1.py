class Solution:
    def climbStairs(self, n: int) -> int:
        seen = {0: 0, 1: 1, 2: 2}

        def dfs(i):
            if i in seen:
                return seen[i]

            if i <= 1:
                return i

            seen[i] = dfs(i-1) + dfs(i-2)
            return seen[i]

        return dfs(n)