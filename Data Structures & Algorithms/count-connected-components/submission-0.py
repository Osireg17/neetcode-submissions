class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        num_components = 0
        adj_map = {i: [] for i in range(n)}
        for u, v in edges:
            adj_map[u].append(v)
            adj_map[v].append(u)

        visited = set()

        def dfs(node):
            visited.add(node)
            for neighbor in adj_map[node]:
                if neighbor not in visited:
                    dfs(neighbor)

        for i in range(n):
            if i not in visited:
                num_components += 1
                dfs(i)
        return num_components