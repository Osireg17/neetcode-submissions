class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][1];
            int value = prerequisites[i][0];
            adjacencyMap.putIfAbsent(key, new ArrayList<>());
            adjacencyMap.get(key).add(value);
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adjacencyMap, currentPath, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, Map<Integer, List<Integer>> adjacencyMap, Set<Integer> currentPath, Set<Integer> visited) {

        List<Integer> neighbors = adjacencyMap.get(node);
        if (neighbors == null) {
            return false;
        }

        if (currentPath.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        currentPath.add(node);
        visited.add(node);

        for (int neighbor : neighbors) {
            if (hasCycle(neighbor, adjacencyMap, currentPath, visited)) {
                return true;
            }
        }

        currentPath.remove(node);
        return false;

    }
}
