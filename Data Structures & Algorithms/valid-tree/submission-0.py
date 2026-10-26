class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        """
        What makes a tree a tree
        is that it's undirected, one unique path between nodes
        Every node has exactly one parent
        There are no cycles

        Need to track the visited nodes and the parent of the current node

        If you see a node that's already visited and it's not the parent that a cycle

        If some nodes aren't connected then it's not a cycle

        If the dfs complete without a cycle len visited must equal to n for it to be a valid graph
        """

        # First create the adjacency map
        adjacency_map = {key: [] for key in range(n)}
        for key, value in edges:
            adjacency_map[key].append(value)
            adjacency_map[value].append(key)

        visited = set()
        stack = [(0, -1)]

        while stack:
            node, parent = stack.pop()
            visited.add(node)
            for neighbour in adjacency_map[node]:
                if neighbour == parent:
                    continue
                elif neighbour in visited:
                    return False
                else:
                    visited.add(neighbour)
                    stack.append((neighbour, node))

        return len(visited) == n
