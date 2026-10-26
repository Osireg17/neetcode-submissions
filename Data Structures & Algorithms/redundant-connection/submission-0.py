class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        # I was too eager to implement the iterative DFS and that's what messed me up, I should have walked through my solution first

        # The iterative solution does work here in this implementation as well which is nice to know, we just need to be a little careful when adding values to the stack, we add the current and parent node

        # We run a dfs whilst building the adjacency map, that's the general trick
        adjacency_map = {key: [] for key in range(1, len(edges) + 1)}

        def has_cycle(start):
            visited = set()
            stack = [(start, -1)]  # (current_node, parent_node)

            while stack:
                node, parent = stack.pop()
                if node in visited:
                    return True
                visited.add(node)

                for neighbor in adjacency_map[node]:
                    if neighbor != parent:
                        stack.append((neighbor, node))
            return False

        for u, v in edges:
            adjacency_map[u].append(v)
            adjacency_map[v].append(u)

            visited = set()
            if has_cycle(u):
                return [u, v]
        return []