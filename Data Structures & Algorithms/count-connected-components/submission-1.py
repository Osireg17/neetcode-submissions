class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adjacency_map = {key: [] for key in range(n)}
        for key, value in edges:
            adjacency_map[key].append(value)
            adjacency_map[value].append(key)

        visited = set()
        stack = []
        result = 0

        for i in range(n):
            if i in visited:
                continue
            stack.append(i)
            while stack:
                node = stack.pop()
                visited.add(node)
                for neighbour in adjacency_map[node]:
                    if neighbour not in visited:
                        stack.append(neighbour)
            result += 1

        return result