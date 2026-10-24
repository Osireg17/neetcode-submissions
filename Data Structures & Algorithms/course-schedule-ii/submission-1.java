class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][1];
            int value = prerequisites[i][0];
            adjacencyMap.putIfAbsent(key, new ArrayList<>());
            adjacencyMap.get(key).add(value);
        }

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> visit = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacencyMap, visit, cycle, result)) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

        private boolean dfs(int node, Map<Integer, List<Integer>> adjacencyMap, HashSet<Integer> visit, HashSet<Integer> cycle, List<Integer> result) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visit.contains(node)) {
            return true;
        }

        cycle.add(node);
        List<Integer> neighbors = adjacencyMap.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!dfs(neighbor, adjacencyMap, visit, cycle, result)) {
                return false;
            }
        }
        cycle.remove(node);
        visit.add(node);
        result.add(node);
        return true;
    }


}
